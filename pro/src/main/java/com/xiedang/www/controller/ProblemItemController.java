package com.xiedang.www.controller;

import com.xiedang.www.service.ProblemItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Mr.zyk
 * @Description: ${description}
 * @Date: 2019/1/5 19:52
 */
@Controller
@RequestMapping("/measure")
public class ProblemItemController {

    @Autowired
    private ProblemItemService problemItemService;

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public Object selectByPrimaryKey(HttpServletRequest request,Integer parentid){
        return problemItemService.selectByPrimaryKey(parentid);
    }
}
