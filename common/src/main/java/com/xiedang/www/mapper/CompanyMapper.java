package com.xiedang.www.mapper;

import com.xiedang.www.model.Company;

public interface CompanyMapper {
    /**
     *  根据主键删除数据库的记录,company
     *
     * @param companyId
     */
    int deleteByPrimaryKey(String companyId);

    /**
     *  新写入数据库记录,company
     *
     * @param record
     */
    int insert(Company record);

    /**
     *  动态字段,写入数据库记录,company
     *
     * @param record
     */
    int insertSelective(Company record);

    /**
     *  根据指定主键获取一条数据库记录,company
     *
     * @param companyId
     */
    Company selectByPrimaryKey(String companyId);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,company
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Company record);

    /**
     *  根据主键来更新符合条件的数据库记录,company
     *
     * @param record
     */
    int updateByPrimaryKey(Company record);
}