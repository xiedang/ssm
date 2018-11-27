package com.xiedang.www.controller;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.constant.UserConstant;
import com.xiedang.www.model.User;
import com.xiedang.www.service.UserService;
import com.xiedang.www.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/2 13:29
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    /**
     * <p>用户登录</p>
     *
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public Object login(HttpServletRequest request, User user) {
        log.info("用户登录,参数{}", user);
        ModelAndView modelAndView = new ModelAndView();

        User u = userService.login(user.getUsername());

        if(!StringUtils.isEmpty(u)){
            if(u.getPassword().equals(user.getPassword())){
                request.getSession().setAttribute("user", user);
                modelAndView.setViewName(UserConstant.WELCOME);
                modelAndView.addObject("msg1","登录成功");
            }else {
                modelAndView.setViewName(UserConstant.LOGIN);
                modelAndView.addObject("msg2","密码错误");
            }
        }else {
            modelAndView.setViewName(UserConstant.LOGIN);
            modelAndView.addObject("msg3","用户名不存在");
        }
        return modelAndView;
    }

    /**
     * <p>查询所有用户</p>
     *
     * @param request
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(HttpServletRequest request) {
        log.info("查询所有用户,参数{}");
        //ModelAndView modelAndView = new ModelAndView();
        List<UserBo> userBos = new ArrayList<>();
        try {
            userBos = userService.selectAll();
            //modelAndView.addObject("users",userBos);
            //modelAndView.setViewName("welcome");
        } catch (Exception e) {
            log.error("查询所有用户错误，{}", e);
            e.printStackTrace();
        }
        return userBos;
        //return modelAndView;
    }

    /**
     * <p>导出用户excel</p>
     *
     * @param request
     * @return
     */
    @RequestMapping("/exportExcel")
    @ResponseBody
    public Object exportExcel(HttpServletRequest request, HttpServletResponse response) {
        log.info("导出用户excel,参数{}");
        List<UserBo> userBos = new ArrayList<>();
        try {
            userBos = userService.exportExcel(response);
        } catch (Exception e) {
            log.error("导出用户excel错误，{}", e);
            e.printStackTrace();
        }
        return userBos;
    }

    @RequestMapping("/queryUser")
    @ResponseBody
    public Object queryUser(HttpServletRequest request, UserVo userVo){
        log.info("用户查询,参数{}",userVo);
        List<UserBo> userBos = new ArrayList<>();
        try {
            userBos = userService.queryUser(userVo);
        } catch (Exception e) {
            log.error("根据条件查询用户错误，{}", e);
            e.printStackTrace();
        }
        return userBos;
    }
}
