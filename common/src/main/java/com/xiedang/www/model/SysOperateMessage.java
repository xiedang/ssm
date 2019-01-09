package com.xiedang.www.model;

import java.util.Date;

/**
 * 系统操作信息表
 * SysOperateMessage
 * 数据库表：sys_operate_message
 */
public class SysOperateMessage {

    /**
     * 
     * 表字段 : sys_operate_message.id
     */
    private Integer id;

    /**
     * 操作人
     * 表字段 : sys_operate_message.operator
     */
    private String operator;

    /**
     * 
     * 表字段 : sys_operate_message.oprate_time
     */
    private Date oprateTime;

    /**
     * 操作方法
     * 表字段 : sys_operate_message.operate_method
     */
    private String operateMethod;

    /**
     * 操作参数
     * 表字段 : sys_operate_message.operate_paras
     */
    private String operateParas;

    /**
     * 返回信息
     * 表字段 : sys_operate_message.return_data
     */
    private String returnData;

    /**
     * 执行时间
     * 表字段 : sys_operate_message.exec_time
     */
    private String execTime;

    /**
     * 获取  字段:sys_operate_message.id
     *
     * @return sys_operate_message.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:sys_operate_message.id
     *
     * @param id the value for sys_operate_message.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 操作人 字段:sys_operate_message.operator
     *
     * @return sys_operate_message.operator, 操作人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置 操作人 字段:sys_operate_message.operator
     *
     * @param operator the value for sys_operate_message.operator, 操作人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取  字段:sys_operate_message.oprate_time
     *
     * @return sys_operate_message.oprate_time, 
     */
    public Date getOprateTime() {
        return oprateTime;
    }

    /**
     * 设置  字段:sys_operate_message.oprate_time
     *
     * @param oprateTime the value for sys_operate_message.oprate_time, 
     */
    public void setOprateTime(Date oprateTime) {
        this.oprateTime = oprateTime;
    }

    /**
     * 获取 操作方法 字段:sys_operate_message.operate_method
     *
     * @return sys_operate_message.operate_method, 操作方法
     */
    public String getOperateMethod() {
        return operateMethod;
    }

    /**
     * 设置 操作方法 字段:sys_operate_message.operate_method
     *
     * @param operateMethod the value for sys_operate_message.operate_method, 操作方法
     */
    public void setOperateMethod(String operateMethod) {
        this.operateMethod = operateMethod == null ? null : operateMethod.trim();
    }

    /**
     * 获取 操作参数 字段:sys_operate_message.operate_paras
     *
     * @return sys_operate_message.operate_paras, 操作参数
     */
    public String getOperateParas() {
        return operateParas;
    }

    /**
     * 设置 操作参数 字段:sys_operate_message.operate_paras
     *
     * @param operateParas the value for sys_operate_message.operate_paras, 操作参数
     */
    public void setOperateParas(String operateParas) {
        this.operateParas = operateParas == null ? null : operateParas.trim();
    }

    /**
     * 获取 返回信息 字段:sys_operate_message.return_data
     *
     * @return sys_operate_message.return_data, 返回信息
     */
    public String getReturnData() {
        return returnData;
    }

    /**
     * 设置 返回信息 字段:sys_operate_message.return_data
     *
     * @param returnData the value for sys_operate_message.return_data, 返回信息
     */
    public void setReturnData(String returnData) {
        this.returnData = returnData == null ? null : returnData.trim();
    }

    /**
     * 获取 执行时间 字段:sys_operate_message.exec_time
     *
     * @return sys_operate_message.exec_time, 执行时间
     */
    public String getExecTime() {
        return execTime;
    }

    /**
     * 设置 执行时间 字段:sys_operate_message.exec_time
     *
     * @param execTime the value for sys_operate_message.exec_time, 执行时间
     */
    public void setExecTime(String execTime) {
        this.execTime = execTime == null ? null : execTime.trim();
    }
}