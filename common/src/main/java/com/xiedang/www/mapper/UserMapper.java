package com.xiedang.www.mapper;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.model.User;
import com.xiedang.www.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     *  根据主键删除数据库的记录,user
     *
     * @param id
     */
    int deleteByPrimaryKey(String id);

    /**
    *
    * @Description:  根据主键批量删除数据库的记录,user
    * @Param:
    * @return:
    * @Author: Mr.Michelle
    * @Date: 下午 10:40 2018/11/30 0030
    *
    */
    int deleteByPrimaryKeys(String[] ids);

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
     * @param vo
     */
    int updateByPrimaryKeySelective(UserVo vo);

    /**
     *  根据主键来更新符合条件的数据库记录,user
     *
     * @param record
     */
    int updateByPrimaryKey(User record);

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
    List<UserBo> queryUserByPage(Map map);
}