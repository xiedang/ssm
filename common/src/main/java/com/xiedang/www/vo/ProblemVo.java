package com.xiedang.www.vo;

import com.xiedang.www.model.Problem;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: Mr.zyk
 * @Description: ${页面传递到后台数据封装}
 * @Date: 2018/12/22 12:21
 */
public class ProblemVo extends Problem {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pFindTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pPlanTime;

    @Override
    public Date getpFindTime() {
        return pFindTime;
    }

    @Override
    public void setpFindTime(Date pFindTime) {
        this.pFindTime = pFindTime;
    }

    @Override
    public Date getpPlanTime() {
        return pPlanTime;
    }

    @Override
    public void setpPlanTime(Date pPlanTime) {
        this.pPlanTime = pPlanTime;
    }
}
