package com.xiedang.www.service.impl;

import com.xiedang.www.bo.ProblemBo;
import com.xiedang.www.mapper.ProblemMapper;
import com.xiedang.www.service.ProblemService;
import com.xiedang.www.vo.ProblemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.zyk
 * @Description: ${description}
 * @Date: 2018/12/22 20:00
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public ProblemBo selectById(Integer id) {
        return problemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProblemBo> queryAllByPage(Map map) {
        return problemMapper.selectAllByPage(map);
    }

    @Override
    public List<ProblemBo> query(ProblemVo problemVo) {
        return problemMapper.selectProblem(problemVo);
    }

    @Override
    public int addProblem(ProblemVo problemVo) {
        return problemMapper.insertSelective(problemVo);
    }

    @Override
    public int updateProblem(ProblemVo problemVo) {
        return problemMapper.updateByPrimaryKeySelective(problemVo);
    }

    @Override
    public int deleteProblem(String[] str) {
        return problemMapper.deleteByPrimaryKey(str);
    }
}
