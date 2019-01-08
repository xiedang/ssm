package com.xiedang.www.controller.app;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author : 谢当
 * @Date: : 2018/11/2 13:29
 */
@Controller
@RequestMapping("/appUser")
public class AppUserController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有服务商", notes = "返回服务商实体对象")
    @RequestMapping(value="selectAll", method=RequestMethod.POST)
    @ResponseBody
    public Object selectAll(HttpServletRequest request){
        log.info("查询所有用户,参数{}");
        List<UserBo> userBos = new ArrayList<>();
        try {
            userBos = userService.selectAll();
        } catch (Exception e) {
            log.error("查询所有用户错误，{}", e);
            e.printStackTrace();
        }
        return userBos;
    }
}
