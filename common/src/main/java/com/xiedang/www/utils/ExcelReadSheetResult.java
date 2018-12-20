package com.xiedang.www.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <P>读取excel的时候,每个sheet的返回结果</P>
 */
public class ExcelReadSheetResult extends BaseObject {

    /**
     * TODO
     */
    private static final long serialVersionUID = 1L;

    /**
     * sheet的序号
     */
    private int sheetIndex;

    /**
     * sheet的名称
     */
    private String sheetName;

    /**
     * 总行数
     */
    private int totalRowCount;

    /**
     * 总列数
     */
    private int totalComulnCount;

    /**
     * 头的行数
     */
    private int headerRowCount;

    /**
     * 头的列数(每一行多少列)
     */
    private int headerColumnCount;

    /**
     * 头部数据
     */
    private List<String[]> headerDatas = new ArrayList<> ();

    /**
     * 处理后的头部数据
     */
    private List<String> handledHeader = new ArrayList<>();

    /**
     * 中间内容的数据
     */
    private List<String[]> bodyDatas = new ArrayList<>();

    public int getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public int getHeaderRowCount() {
        return headerRowCount;
    }

    public void setHeaderRowCount(int headerRowCount) {
        this.headerRowCount = headerRowCount;
    }

    public int getHeaderColumnCount() {
        return headerColumnCount;
    }

    public void setHeaderColumnCount(int headerColumnCount) {
        this.headerColumnCount = headerColumnCount;
    }

    public List<String[]> getHeaderDatas() {
        return headerDatas;
    }

    public void setHeaderDatas(List<String[]> headerDatas) {
        this.headerDatas = headerDatas;
    }

    public List<String[]> getBodyDatas() {
        return bodyDatas;
    }

    public void setBodyDatas(List<String[]> bodyDatas) {
        this.bodyDatas = bodyDatas;
    }

    public int getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(int totalRowCount) {
        this.totalRowCount = totalRowCount;
    }

    public int getTotalComulnCount() {
        return totalComulnCount;
    }

    public void setTotalComulnCount(int totalComulnCount) {
        this.totalComulnCount = totalComulnCount;
    }

    public List<String> getHandledHeader() {
        return handledHeader;
    }

    public void setHandledHeader(List<String> handledHeader) {
        this.handledHeader = handledHeader;
    }


}
