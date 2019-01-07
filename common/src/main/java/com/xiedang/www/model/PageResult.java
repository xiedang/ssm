package com.xiedang.www.model;

import com.github.pagehelper.Page;

import java.util.List;

public class PageResult<T> {
    private static final long serialVersionUID = 1L;
    private int pageNum;
    private int pageSize;
    private long total;
    private int pages;
    private List<T> rows;

    public PageResult(Page<T> page) {
        this.pageNum=page.getPageNum();
        this.pageSize=page.getPageSize();
        this.total=page.getTotal();
        this.pages=page.getPages();
        this.rows=page.getResult();
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}

