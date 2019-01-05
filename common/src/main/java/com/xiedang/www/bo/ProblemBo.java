package com.xiedang.www.bo;

import com.xiedang.www.model.Problem;
import com.xiedang.www.model.ProblemItem;

/**
 * @Author: Mr.zyk
 * @Description: ${description}
 * @Date: 2018/12/22 12:24
 */
public class ProblemBo extends Problem {

    private ProblemItem problemItem;

    public ProblemItem getProblemItem() {
        return problemItem;
    }

    public void setProblemItem(ProblemItem problemItem) {
        this.problemItem = problemItem;
    }
}
