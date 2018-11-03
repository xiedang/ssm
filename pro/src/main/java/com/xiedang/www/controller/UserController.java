package com.xiedang.www.controller;

import com.xiedang.www.model.User;
import com.xiedang.www.service.UserService;
import com.xiedang.www.utils.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    @ResponseBody
    public Object login(HttpServletRequest request, User user) {
        log.info("用户登录,参数{}", user);
        CommonResult<String> result = new CommonResult<>(CommonResult.FAILURE_CODE);
        try {
            result = userService.login(user);
        } catch (Exception e) {
            log.error("用户登录错误，{}", e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * <p>查询所有用户</p>
     *
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(HttpServletRequest request, User user) {
        log.info("查询所有用户,参数{}", user);
        List<User> users = new ArrayList<>();
        try {
            users = userService.selectAll(user);
        } catch (Exception e) {
            log.error("查询所有用户错误，{}", e);
            e.printStackTrace();
        }
        return users;
    }
}
