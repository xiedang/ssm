package com.xiedang.www.mapper;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.model.User;
import com.xiedang.www.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * @author zyk
 */
public interface UserMapper {
    /**
     *  根据主键删除数据库的记录,user
     *
     * @param id
     */
    int deleteByPrimaryKey(String[] id);

    /**
     *  新写入数据库记录,user
     *
     * @param record
     */
    int insert(User record);

    /**
     *  动态字段,写入数据库记录,user
     *
     * @param userVo
     */
    int insertSelective(UserVo userVo);

    /**
     *  根据指定主键获取一条数据库记录,user
     *
     * @param id
     */
    UserBo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user
     *
     * @param userVo
     */
    int updateByPrimaryKeySelective(UserVo userVo);

    /**
     *  根据主键来更新符合条件的数据库记录,user
     *
     * @param record
     */
    int updateByPrimaryKey(User record);
    /**
     * 批量插入用户
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
     *  根据用户名查询用户
     *
     * @param username
     */
    User selectByUsername(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<UserBo> selectAll();

    /**
     * 根据条件查询用户
     * @return
     */
    List<UserBo> queryUser(UserVo userVo);

    /**
     * 查询所有登录信息
     * @return
     */
    List<User> selectAllLoginInfo();

    /**
     *
     * @Description: 分页查询
     * @Param:
     * @return:
     * @Author: Mr.Michelle
     * @Date: 下午 9:02 2018/12/11 0011
     *
     */
    List<UserBo> queryUserByPage(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    List<User> selectUserByPage(Map<String,Object> map);

    /**
     * @Author: Mr.zyk
     * @Description: 根据用户名获取用户名字
     * @param: [username]
     * @Return: com.xiedang.www.bo.UserBo
     * @Date: 2018/12/30 11:27
     */
    String getNameByUserName(String username);
}