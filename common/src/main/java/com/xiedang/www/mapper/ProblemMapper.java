package com.xiedang.www.mapper;

import com.github.pagehelper.Page;
import com.xiedang.www.bo.ProblemBo;
import com.xiedang.www.model.Problem;
import com.xiedang.www.vo.ProblemVo;

import java.util.List;
import java.util.Map;

/**
 * @author zyk
 */
public interface ProblemMapper {

    /**
     *  根据主键删除数据库的记录,problem
     *
     * @param str
     */
    int deleteByPrimaryKey(String[] str);

    /**
     *  新写入数据库记录,problem
     *
     * @param problemVo
     */
    int insert(ProblemVo problemVo);

    /**
     *  动态字段,写入数据库记录,problem
     *
     * @param problemVo
     */
    int insertSelective(ProblemVo problemVo);

    /**
     *  根据指定主键获取一条数据库记录,problem
     *
     * @param id
     */
    ProblemBo selectByPrimaryKey(Integer id);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,problem
     *
     * @param problemVo
     */
    int updateByPrimaryKeySelective(ProblemVo problemVo);

    /**
     *  根据主键来更新符合条件的数据库记录,problem
     *
     * @param record
     */
    int updateByPrimaryKey(Problem record);

    /**
     * @Author: Mr.zyk
     * @Description: 条件查询
     * @param: [problemVo]
     * @Return: java.util.List<com.xiedang.www.bo.ProblemBo>
     * @Date: 2018/12/22 12:52
     */
    List<ProblemBo> selectProblem(ProblemVo problemVo);

    /**
     * @Author: Mr.zyk
     * @Description: 分页查询数据
     * @param: [map]
     * @Return: java.util.List<com.xiedang.www.bo.ProblemBo>
     * @Date: 2018/12/22 19:51
     */
    List<ProblemBo> selectAllByPage(Map<String,Object> map);

    /**
     * @Author: Mr.zyk
     * @Description: 审批
     * @param: [problemVo]
     * @Return: int
     * @Date: 2018/12/28 11:28
     */
    int updateApproveStatus(ProblemVo problemVo);

    /**
     * @Author: Mr.zyk
     * @Description: 查找当天生成的记录数
     * @param: []
     * @Return: int
     * @Date: 2018/12/28 11:31
     */
    int problemCount();

    /**
     * @Author: Mr.zyk
     * @Description: pageHelper初使用
     * @param: []
     * @Return: java.util.List<com.xiedang.www.bo.UserBo>
     * @Date: 2019/1/2 20:13
     */
    Page<ProblemBo> selectByPageAndSelections(ProblemVo problemVo);
}