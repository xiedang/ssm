package com.xiedang.www.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiedang.www.bo.ProblemBo;
import com.xiedang.www.mapper.ProblemItemMapper;
import com.xiedang.www.mapper.ProblemMapper;
import com.xiedang.www.model.PageResult;
import com.xiedang.www.service.ProblemService;
import com.xiedang.www.utils.date.DateUtil;
import com.xiedang.www.utils.str.StrUtil;
import com.xiedang.www.vo.ProblemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ProblemItemMapper problemItemMapper;

    @Override
    public ProblemBo selectById(Integer id) {
        return problemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProblemBo> queryAllByPage(Map<String,Object> map) {
        return problemMapper.selectAllByPage(map);
    }

    @Override
    public List<ProblemBo> query(ProblemVo problemVo) {
        return problemMapper.selectProblem(problemVo);
    }

    @Override
    public int addProblem(ProblemVo problemVo) {
        //问题编号
        problemVo.setpNo(getNo());
        return problemMapper.insertSelective(problemVo) + problemItemMapper.insertSelective(problemVo);
    }

    @Override
    public int updateProblem(ProblemVo problemVo) {
        return problemMapper.updateByPrimaryKeySelective(problemVo);
    }

    @Override
    public int deleteProblem(String[] str) {
        return problemMapper.deleteByPrimaryKey(str);
    }

    @Override
    public int updateApproveStatus(ProblemVo problemVo) {
        String str = problemVo.getpStatus();
        String s = "1";
        if (s.equals(str)){
            problemVo.setpStatus("已审批");
        }else {
            problemVo.setpStatus("已驳回");
        }
        return problemMapper.updateApproveStatus(problemVo);
    }

    @Override
    public synchronized String getNo() {
        String format = DateUtil.format(new Date(), "yyyyMMdd");
        //当天添加的数据条数
        int count = problemMapper.problemCount();
        String s = "WT" + format + StrUtil.autoGenericCode(count,5);
        return s;
    }

    @Override
    public PageResult<ProblemBo> selectByPageAndSelections(int currentPage, int pageSize,ProblemVo problemVo) {
        PageHelper.startPage(currentPage,pageSize);
        Page<ProblemBo> page = problemMapper.selectByPageAndSelections(problemVo);
        PageResult<ProblemBo> pageResult = new PageResult<>(page);
        return pageResult;
    }
}
