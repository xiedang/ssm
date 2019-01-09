package com.xiedang.www.mapper;

import com.xiedang.www.model.SysOperateMessage;

public interface SysOperateMessageMapper {
    /**
     *  根据主键删除数据库的记录,sys_operate_message
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,sys_operate_message
     *
     * @param record
     */
    int insert(SysOperateMessage record);

    /**
     *  动态字段,写入数据库记录,sys_operate_message
     *
     * @param record
     */
    int insertSelective(SysOperateMessage record);

    /**
     *  根据指定主键获取一条数据库记录,sys_operate_message
     *
     * @param id
     */
    SysOperateMessage selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,sys_operate_message
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SysOperateMessage record);

    /**
     *  根据主键来更新符合条件的数据库记录,sys_operate_message
     *
     * @param record
     */
    int updateByPrimaryKey(SysOperateMessage record);
}