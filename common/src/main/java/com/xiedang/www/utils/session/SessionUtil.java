package com.xiedang.www.utils.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * session工具类
 **/
public class SessionUtil {

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    /**
     * 获取session
     *
     * @return
     */
    public static HttpSession getSession() {
        return getRequest()==null?null:getRequest().getSession(false);
    }

    /**
     * 获取真实路径（即文件路径，一般用于上传下载）
     *
     * @return
     */
    public static String getRealRootPath() {
        return getRequest()==null?null:getRequest().getServletContext().getRealPath("/");
    }

    /**
     * 获取ip
     *
     * @return
     */
    public static String getIp() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (servletRequestAttributes != null) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            return request.getRemoteAddr();
        }
        return null;
    }

    /**
     * 获取session中的Attribute
     *
     * @param name
     * @return
     */
    public static Object getSessionAttribute(String name) {
        HttpServletRequest request = getRequest();
        return request == null ? null : request.getSession().getAttribute(name);
    }

    /**
     * 设置session的Attribute
     *
     * @param name
     * @param value
     */
    public static void setSessionAttribute(String name, Object value) {
        HttpServletRequest request = getRequest();
        if (request != null) {
            request.getSession().setAttribute(name, value);
        }
    }

    /**
     * 获取request中的Attribute
     *
     * @param name
     * @return
     */
    public static Object getRequestAttribute(String name) {
        HttpServletRequest request = getRequest();
        return request == null ? null : request.getAttribute(name);
    }

    /**
     * 设置request的Attribute
     *
     * @param name
     * @param value
     */
    public static void setRequestAttribute(String name, Object value) {
        HttpServletRequest request = getRequest();
        if (request != null) {
            request.setAttribute(name, value);
        }
    }

    /**
     * 获取上下文path(一般为项目名称)
     *
     * @return
     */
    public static String getContextPath() {
        return getRequest()==null?null:getRequest().getContextPath();
    }

    /**
     * 删除session中的Attribute
     *
     * @param name
     */
    public static void removeSessionAttribute(String name) {
        if(getRequest()!=null) {
            getRequest().getSession().removeAttribute(name);
        }
    }

    /**
     * 删除session中的Attribute
     */
    public static void removeSession() {
        if(getRequest()!=null) {
            HttpSession session = getRequest().getSession();
            session.invalidate();
        }
    }
}

