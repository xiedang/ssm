package com.xiedang.www.mapper;

import com.xiedang.www.model.User;
import com.xiedang.www.model.UserBak;

import java.util.List;

public interface UserBakMapper {
    /**
     *  根据主键删除数据库的记录,user_bak
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,user_bak
     *
     * @param record
     */
    int insert(UserBak record);

    /**
     *  动态字段,写入数据库记录,user_bak
     *
     * @param record
     */
    int insertSelective(UserBak record);

    /**
     *  根据指定主键获取一条数据库记录,user_bak
     *
     * @param id
     */
    UserBak selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user_bak
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserBak record);

    /**
     *  根据主键来更新符合条件的数据库记录,user_bak
     *
     * @param record
     */
    int updateByPrimaryKey(UserBak record);

    /**
     * 批量插入用户
     * @param users
     * @return
     */
    int batchInsert(List<User> users);

    /**
     * 删除所有数据
     */
    void deleteAll();
}