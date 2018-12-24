package com.xiedang.www.service;

import com.xiedang.www.bo.ProblemBo;
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
     *
     * @param id
     * @return
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

    int updateProblem(ProblemVo problemVo);

    int deleteProblem(String[] str);
}
