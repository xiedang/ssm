package com.xiedang.www.interceptor;

import com.xiedang.www.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class SystemInterceptor implements HandlerInterceptor {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        User user = (User)request.getSession().getAttribute("User");
        log.info("登陆信息，{}",user);
        if(null!=user){
            return true;
        }else {
            StringBuffer url = request.getRequestURL();
            String baseUrl =url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
            response.setContentType("text/html;charset=UTF-8");
            // 未登录
            PrintWriter out = response.getWriter();
            String builder = "<script type=\"text/javascript\" charset=\"UTF-8\">" +
                    "window.top.location.href=\"" +baseUrl
                     + "/index.jsp" + "\";</script>";
            out.print(builder);
            out.close();
        }
        return false;
    }

    private boolean notCheck(HttpServletRequest request){
        String requestURI = request.getRequestURI();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
