package com.xiedang.www.service;

import com.xiedang.www.bo.ProblemItemBo;

import java.util.List;

/**
 * @Author: Mr.zyk
 * @Description: ${根据问题制定措施}
 * @Date: 2019/1/5 19:42
 */
public interface ProblemItemService {

    /**
     * @Author: Mr.zyk
     * @Description: 根据pid获取数据
     * @param: [id]
     * @Return: java.util.List<com.xiedang.www.bo.ProblemItemBo>
     * @Date: 2019/1/5 19:45
     */
    List<ProblemItemBo> selectByPrimaryKey(Integer id);
}
