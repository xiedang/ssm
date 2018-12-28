package com.xiedang.www.mapper;

import com.xiedang.www.model.BillFiles;

public interface BillFilesMapper {
    /**
     *  根据主键删除数据库的记录,bill_files
     *
     * @param bfsId
     */
    int deleteByPrimaryKey(Integer bfsId);

    /**
     *  新写入数据库记录,bill_files
     *
     * @param record
     */
    int insert(BillFiles record);

    /**
     *  动态字段,写入数据库记录,bill_files
     *
     * @param record
     */
    int insertSelective(BillFiles record);

    /**
     *  根据指定主键获取一条数据库记录,bill_files
     *
     * @param bfsId
     */
    BillFiles selectByPrimaryKey(Integer bfsId);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,bill_files
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BillFiles record);

    /**
     *  根据主键来更新符合条件的数据库记录,bill_files
     *
     * @param record
     */
    int updateByPrimaryKey(BillFiles record);
}