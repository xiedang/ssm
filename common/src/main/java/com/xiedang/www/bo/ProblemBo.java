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
    /**
     * 当前页数
     */
    /*private int pageNum;*/
    /**
     * 一个页面显示条数
     */
    /*private int pageSize;*/
    /**
     * 分页起始行
     */
    /*private int startRow;*/
    /**
     * 分页结束行
     */
    /*private int endRow;*/
    /**
     * 数据总条数
     */
    /*private long total;*/
    /**
     * 分页总数
     */
    /*private int pages;*/

   /* public ProblemBo(Page<ProblemBo> page) {
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.startRow = page.getStartRow();
        this.endRow = page.getEndRow();
        this.total = page.getTotal();
        this.pages = page.getPages();
    }*/

    public ProblemItem getProblemItem() {
        return problemItem;
    }

    public void setProblemItem(ProblemItem problemItem) {
        this.problemItem = problemItem;
    }
}
