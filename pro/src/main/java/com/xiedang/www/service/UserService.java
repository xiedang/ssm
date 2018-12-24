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
     * @param userVo
     * @return
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
     * @param key
     * @return
     */
    int doDeleteUser(String key);

    /**
     *
     * @param ids
     * @return
     */
    int doDeleteUsers(String[] ids);

    /**
     *
     * @param vo
     * @return
     */
    int updateUserById(UserVo vo);

    /**
     *
     * @param id
     * @return
     */
    UserBo getUserById(Integer id);

    /**
     *
     * @param map
     * @return
     */
    List<UserBo> queryUserByPage(Map map);

    /**
     *
     * @param list
     */
    void insertInfoBatch(List<UserBo> list);
}
