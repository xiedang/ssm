package com.xiedang.www.controller;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.constant.UserConstant;
import com.xiedang.www.model.User;
import com.xiedang.www.service.UserService;
import com.xiedang.www.utils.common.CommonResult;
import com.xiedang.www.utils.str.ThreeDESUtil;
import com.xiedang.www.vo.UserVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author : 谢当
 * @Date: : 2018/11/2 13:29
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
     * @Param: request
     * @Param: user
     * @return:
     */
    @RequestMapping("/login")
    public Object login(HttpServletRequest request, User user) {
        log.info("用户登录,参数{}", user);
        ModelAndView modelAndView = new ModelAndView();

        User u = userService.login(user.getUsername());

        if (null != u) {
            if (u.getPassword().equals(user.getPassword())) {
                request.getSession().setAttribute("user", user);
                modelAndView.setViewName(UserConstant.WELCOME);
                modelAndView.addObject("msg1", "登录成功");
            } else {
                modelAndView.setViewName(UserConstant.LOGIN);
                modelAndView.addObject("msg2", "密码错误");
            }
        } else {
            modelAndView.setViewName(UserConstant.LOGIN);
            modelAndView.addObject("msg3", "用户名不存在");
        }
        return modelAndView;
    }

    /**
     * <p>查询所有用户</p>
     *
     * @Param: request
     * @return:
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(HttpServletRequest request) {
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

    /**
     * <p>查询所有登录信息</p>
     *
     * @param request
     * @return:
     */
    @RequestMapping(value = "/selectAllLoginInfo", method = RequestMethod.POST, /*headers = { "password=zyk1314654321", "cipher=Gp4d2x2u373Klu+IX34BrA=="},*/
            produces = {"application/json;charset=utf-8"}, consumes = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object selectAllLoginInfo(HttpServletRequest request, @RequestBody User user) throws Exception {
        CommonResult<User> result = new CommonResult<>(CommonResult.FAILURE_CODE);
        log.info("查询所有登录信息,参数{}", user);
        String password = request.getHeader("password");
        String cipher = request.getHeader("cipher");
        if (StringUtils.isBlank(password) || StringUtils.isBlank(cipher)) {
            result.setMessage("缺少必选参数,请参考API文档");
            return result;
        } else {
            String pwd = ThreeDESUtil.decode3Des(cipher);
            if (password.equals(pwd)) {
                result.setSuccess(CommonResult.SUCCESS_CODE);
                result.setMessage("访问成功");
                List<User> users = userService.selectAllLoginInfo();
                result.setDatas(users);
            } else {
                result.setMessage("您的授权码不正确");
                return result;
            }
        }
        return result;
    }

    /**
     * <p>导出用户excel</p>
     *
     * @param request
     * @return:
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

    /**
     * @Description: 条件查询;
     * @Param:
     * @return:
     * @Author: Mr.Michelle
     * @Date: 下午 9:06 2018/12/3 0003
     */
    @RequestMapping("/queryUser")
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

    /**
     * @Description: 新增
     * @Param:
     * @return:
     * @Author: Mr.Michelle
     * @Date: 下午 9:06 2018/12/3 0003
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser(HttpServletRequest request, UserVo userVo) {
        log.info("新增用户,参数{}", userVo);
        int i = 0;
        try {
            i = userService.addUser(userVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/batchInsertUser")
    @ResponseBody
    public int batchInsertUser(HttpServletRequest request,@RequestBody List<User> users){
        log.info("批量新增用户,参数{}", users);
        int i = 0;
        try {
            i = userService.batchInsert(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @RequestMapping("/batchUpdateUser")
    @ResponseBody
    public int batchUpdateUser(HttpServletRequest request,@RequestBody List<User> users){
        log.info("批量新增用户,参数{}", users);
        int i = 0;
        try {
            i = userService.batchUpdate(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * @Author: Mr.zyk
     * @Description: 删除
     * @param: [request, str]
     * @Return: int
     * @Date: 2018/12/18 20:43
     */
    @RequestMapping("/doDeleteUser")
    @ResponseBody
    public int doDeleteUser(HttpServletRequest request, String str) {
        log.info("删除用户，参数{}", str);
        String[] s = str.split(",");
        int i = 0;
        try {
            i = userService.doDeleteUsers(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * @Author: Mr.zyk
     * @Description: 根据id获取单个用户
     * @param: [request, id]
     * @Return: com.xiedang.www.bo.UserBo
     * @Date: 2018/12/18 20:43
     */
    @RequestMapping("/getUserById")
    @ResponseBody
    public UserBo getUserById(HttpServletRequest request, int id) {
        log.info("根据id获取单个用户信息，参数{}", id);
        return userService.getUserById(id);
    }

    /**
     * @Author: Mr.zyk
     * @Description: 更新
     * @param: [request, vo]
     * @Return: int
     * @Date: 2018/12/18 20:44
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public int updateUser(HttpServletRequest request, UserVo vo) {
        log.info("修改用户,参数{}", vo);
        int i = 0;
        try {
            i = userService.updateUserById(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * @Author: Mr.zyk
     * @Description: 分页查询
     * @param: [request, pageSize, currentPage]
     * @Return: java.lang.Object
     * @Date: 2018/12/18 20:44
     */
    @RequestMapping("/queryUserByPage")
    @ResponseBody
    public Object queryUserByPage(HttpServletRequest request,int pageSize,int currentPage){
        log.info("分页查询,参数{}", pageSize,currentPage);
        Map<String,Object> map = new HashMap<>(16);
        int start = (currentPage-1)*pageSize;
        map.put("start",start);
        map.put("size",pageSize);
        List<UserBo> userBo = new ArrayList<>();
        try {
            userBo = userService.queryUserByPage(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userBo;
    }
}
