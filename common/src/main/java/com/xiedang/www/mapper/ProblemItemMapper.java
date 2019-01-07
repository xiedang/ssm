package com.xiedang.www.mapper;

import com.xiedang.www.bo.ProblemItemBo;
import com.xiedang.www.model.ProblemItem;
import com.xiedang.www.vo.ProblemVo;

import java.util.List;

public interface ProblemItemMapper {
    /**
     *  根据主键删除数据库的记录,problem_item
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,problem_item
     *
     * @param record
     */
    int insert(ProblemItem record);

    /**
     *  动态字段,写入数据库记录,problem_item
     *
     * @param problemVo
     */
    int insertSelective(ProblemVo problemVo);

    /**
     *  根据指定主键获取一条数据库记录,problem_item
     *
     * @param id
     */
    List<ProblemItemBo> selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,problem_item
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ProblemItem record);

    /**
     *  根据主键来更新符合条件的数据库记录,problem_item
     *
     * @param record
     */
    int updateByPrimaryKey(ProblemItem record);
}