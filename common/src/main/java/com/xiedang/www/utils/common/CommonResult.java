package com.xiedang.www.utils.common;

import java.util.List;

public class CommonResult<T> extends BaseObject {
    /**
     * TODO
     */
    private static final long serialVersionUID = 1L;

    public static final Integer SUCCESS_CODE = 0;

    public static final Integer FAILURE_CODE = -1;

    private Integer success = SUCCESS_CODE;

    private String message;

    private T data;

    private List<T> datas;


    public CommonResult(Integer success) {
        super();
        this.success = success;
    }


    public CommonResult(Integer success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public CommonResult(Integer success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    public CommonResult(Integer success, List<T> datas) {
        super();
        this.success = success;
        this.datas = datas;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

}
