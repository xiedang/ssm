package com.xiedang.www.controller.app;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.service.UserService;
import com.xiedang.www.vo.UserVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
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

    @ApiOperation(value = "根据条件查询用户", notes = "返回用户对象")
    @ApiImplicitParams(
            {
                    /*
                     * name：参数名
                     value：参数的汉字说明、解释
                     required：参数是否必须传
                     paramType：参数放在哪个地方
                     · header --> 请求参数的获取：@RequestHeader
                     · query --> 请求参数的获取：@RequestParam
                     · path（用于restful接口）--> 请求参数的获取：@PathVariable
                     · body（不常用）
                     · form（不常用）
                     dataType：参数类型，默认String，其它值dataType="Integer"
                     defaultValue：参数的默认值
                     */
                    @ApiImplicitParam(name = "username",value = "用户名",paramType = "query"),
                    @ApiImplicitParam(name = "password",value = "密码",paramType = "query")
            }
    )
    @RequestMapping(value = "/queryUser",method = RequestMethod.POST)
    @ResponseBody
    public Object queryUser(HttpServletRequest request, UserVo userVo) {
        log.info("用户查询,参数{}", userVo);
        List<UserBo> userBos = new ArrayList<>();
        try {
            userBos = userService.queryUser(userVo);
        } catch (Exception e) {
            log.error("根据条件查询用户错误，{}", e);
            e.printStackTrace();
        }
        return userBos;
    }

    @ApiOperation(value = "查询所有用户", notes = "返回服务商实体对象")
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
