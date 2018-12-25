package com.xiedang.www.utils.excel.model;

import com.xiedang.www.utils.common.CommonResult;

import java.util.List;

/**
 * <P>导入数据后返回的结果</P>
 */
public class ImportExcelResult<T> extends CommonResult<T> {

    /**
     * TODO
     */
    private static final long serialVersionUID = 1L;

    /**
     * 导入数据的总条数
     */
    private Integer totalCount;

    /**
     * 成功的条数
     */
    private Integer successCount;


    public ImportExcelResult(Integer success) {
        super(success);
    }

    public ImportExcelResult(Integer success, List<T> datas) {
        super(success, datas);
    }

    public ImportExcelResult(Integer success, String message) {
        super(success, message);
    }

    public ImportExcelResult(Integer success, T data) {
        super(success, data);
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }


}
