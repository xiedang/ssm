package com.xiedang.www.controller;

import com.xiedang.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Mr.Michelle
 * @date: 下午 8:00 2018/11/3 0003
 */

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/index","/"})
    public Object index(){
        ModelAndView modelAndView = new ModelAndView();

        return "index";
    }
}
