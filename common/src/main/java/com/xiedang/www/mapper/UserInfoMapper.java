package com.xiedang.www.mapper;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.model.UserInfo;
import com.xiedang.www.vo.UserVo;

public interface UserInfoMapper {
    /**
     *  根据主键删除数据库的记录,user_info
     *
     * @param id
     */
    int deleteByPrimaryKey(String[] id);

    /**
     *  新写入数据库记录,user_info
     *
     * @param record
     */
    int insert(UserInfo record);

    /**
     *  动态字段,写入数据库记录,user_info
     *
     * @param userVo
     */
    int insertSelective(UserVo userVo);

    /**
     *  根据指定主键获取一条数据库记录,user_info
     *
     * @param id
     */
    UserBo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user_info
     *
     * @param userVo
     */
    int updateByPrimaryKeySelective(UserVo userVo);

    /**
     *  根据主键来更新符合条件的数据库记录,user_info
     *
     * @param record
     */
    int updateByPrimaryKey(UserInfo record);
}