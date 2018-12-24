package com.xiedang.www.service;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.model.User;
import com.xiedang.www.vo.UserVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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

    /**
     * 批量增加用户
     * @param users
     * @return
     */
    int batchInsert(List<User> users);

    /**
     * 批量更新用户
     * @param users
     * @return
     */
    int batchUpdate(List<User> users);

    /**
    *
    * @Description:  删除用户
    * @Param:
    * @return:
    * @Author: Mr.Michelle
    * @Date: 下午 8:39 2018/11/30 0030
    *
    */
    int doDeleteUser(String key);

    /**
    *
    * @Description:  批量删除用户
    * @Param:
    * @return:
    * @Author: Mr.Michelle
    * @Date: 下午 10:46 2018/11/30 0030
    *
    */
    int doDeleteUsers(String[] ids);

    /**
    *
    * @Description: 更新用户
    * @Param:
    * @return:
    * @Author: Mr.Michelle
    * @Date: 下午 12:52 2018/12/3 0003
    *
    */
    int updateUserById(UserVo vo);

    /**
    *
    * @Description: 根据id获取单个用户信息
    * @Param:
    * @return:
    * @Author: Mr.Michelle
    * @Date: 下午 1:16 2018/12/3 0003
    *
    */
    UserBo getUserById(Integer id);

    /**
    *
    * @Description: 分页查询
    * @Param:
    * @return:
    * @Author: Mr.Michelle
    * @Date: 下午 9:04 2018/12/11 0011
    *
    */
    List<UserBo> queryUserByPage(Map map);
}
