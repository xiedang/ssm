package com.xiedang.www.service;

import com.xiedang.www.bo.ProblemBo;
import com.xiedang.www.model.PageResult;
import com.xiedang.www.vo.ProblemVo;

import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.zyk
 * @Description: ${description}
 * @Date: 2018/12/22 12:54
 */
public interface ProblemService {
    /**
     * @Author: Mr.zyk
     * @Description: 根据id获取单条数据
     * @param: [id]
     * @Return: com.xiedang.www.bo.ProblemBo
     * @Date: 2018/12/26 19:52
     */
    ProblemBo selectById(Integer id);

    /**
     * @Author: Mr.zyk
     * @Description: 分页查询数据
     * @param: [map]
     * @Return: java.util.List<com.xiedang.www.bo.ProblemBo>
     * @Date: 2018/12/22 19:52
     */
    List<ProblemBo> queryAllByPage(Map<String,Object> map);

    /**
     * @Author: Mr.zyk
     * @Description: 条件查询
     * @param: [problemBo]
     * @Return: java.util.List<com.xiedang.www.bo.ProblemBo>
     * @Date: 2018/12/22 19:52
     */
    List<ProblemBo> query(ProblemVo problemVo);

    /**
     * @Author: Mr.zyk
     * @Description: 新增
     * @param: [problemVo]
     * @Return: int
     * @Date: 2018/12/22 19:54
     */
    int addProblem(ProblemVo problemVo);

    /**
     * @Author: Mr.zyk
     * @Description: 更新
     * @param: [problemVo]
     * @Return: int
     * @Date: 2018/12/26 19:20
     */
    int updateProblem(ProblemVo problemVo);

    /**
     * @Author: Mr.zyk
     * @Description: 删除
     * @param: [str]
     * @Return: int
     * @Date: 2018/12/26 19:20
     */
    int deleteProblem(String[] str);

    /**
     * @Author: Mr.zyk
     * @Description: 审批
     * @param: [problemVo]
     * @Return: int
     * @Date: 2018/12/26 19:21
     */
    int updateApproveStatus(ProblemVo problemVo);

    /**
     * @Author: Mr.zyk
     * @Description: 获取问题编号方法
     * @param: []
     * @Return: java.lang.String
     * @Date: 2018/12/26 19:43
     */
    String getNo();

    /**
     * @Author: Mr.zyk
     * @Description: pageHelper分页工具
     * @param: []
     * @Return: com.github.pagehelper.Page<com.xiedang.www.bo.ProblemBo>
     * @Date: 2019/1/2 20:16
     */
    PageResult<ProblemBo> selectByPageAndSelections(int currentPage, int pageSize, ProblemVo problemVo);
}
