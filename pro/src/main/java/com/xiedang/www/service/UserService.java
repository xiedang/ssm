package com.xiedang.www.service;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.model.User;
import com.xiedang.www.vo.UserVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/2 13:29
 */
public interface UserService {
    /**
     * 用户登录
     * @param username
     * @return
     */
    User login(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<UserBo> selectAll();

    /**
     * 查询所有登录信息
     * @return
     */
    List<User> selectAllLoginInfo();

    /**
     * 根据条件查询用户
     * @return
     */
    List<UserBo> queryUser(UserVo userVo);

    /**
     * 导出用户excel
     * @return
     */
    List<UserBo> exportExcel(HttpServletResponse response);

    /**
    *
    * @Description: 新增用户 
    * @Param:  
    * @return:  
    * @Author: Mr.Michelle
    * @Date: 下午 9:18 2018/11/28 0028
    *
    */
    int addUser(UserVo userVo);
    
}
