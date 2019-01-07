package com.xiedang.www.service.impl;

import com.xiedang.www.bo.ProblemItemBo;
import com.xiedang.www.mapper.ProblemItemMapper;
import com.xiedang.www.service.ProblemItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Mr.zyk
 * @Description: ${description}
 * @Date: 2019/1/5 19:47
 */

@Service
public class ProblemItemServiceImpl implements ProblemItemService {

    @Autowired
    private ProblemItemMapper problemItemMapper;

    @Override
    public List<ProblemItemBo> selectByPrimaryKey(Integer id) {
        return problemItemMapper.selectByPrimaryKey(id);
    }
}
