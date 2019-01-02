package com.xiedang.www.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 
 * Problem
 * 数据库表：problem
 * @author zyk
 */
public class Problem {

    /**
     * 问题的id
     * 表字段 : problem.id
     */
    private Integer id;

    /**
     * 问题编号
     * 表字段 : problem.p_no
     */
    private String pNo;

    /**
     * 问题标题
     * 表字段 : problem.p_title
     */
    private String pTitle;

    /**
     * 问题状态1：草稿2：已提交3：已审批4：已驳回
     * 表字段 : problem.p_status
     */
    private String pStatus;

    /**
     * 问题类型
     * 表字段 : problem.p_type
     */
    private String pType;

    /**
     * 问题类型代码
     * 表字段 : problem.p_type_code
     */
    private Integer pTypeCode;

    /**
     * 问题关闭状态
     * 表字段 : problem.p_close_status
     */
    private String pCloseStatus;

    /**
     * 审批驳回的原因
     * 表字段 : problem.p_rejected_reason
     */
    private String pRejectedReason;

    /**
     * 删除状态1：未删除2：已删除
     * 表字段 : problem.p_delete_status
     */
    private Integer pDeleteStatus;

    /**
     * 创建人
     * 表字段 : problem.p_founder
     */
    private String pFounder;

    /**
     * 问题创建时间
     * 表字段 : problem.p_create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date pCreateTime;

    /**
     * 获取 问题的id 字段:problem.id
     *
     * @return problem.id, 问题的id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 问题的id 字段:problem.id
     *
     * @param id the value for problem.id, 问题的id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 问题编号 字段:problem.p_no
     *
     * @return problem.p_no, 问题编号
     */
    public String getpNo() {
        return pNo;
    }

    /**
     * 设置 问题编号 字段:problem.p_no
     *
     * @param pNo the value for problem.p_no, 问题编号
     */
    public void setpNo(String pNo) {
        this.pNo = pNo == null ? null : pNo.trim();
    }

    /**
     * 获取 问题标题 字段:problem.p_title
     *
     * @return problem.p_title, 问题标题
     */
    public String getpTitle() {
        return pTitle;
    }

    /**
     * 设置 问题标题 字段:problem.p_title
     *
     * @param pTitle the value for problem.p_title, 问题标题
     */
    public void setpTitle(String pTitle) {
        this.pTitle = pTitle == null ? null : pTitle.trim();
    }

    /**
     * 获取 问题状态1：草稿2：已提交3：已审批4：已驳回 字段:problem.p_status
     *
     * @return problem.p_status, 问题状态1：草稿2：已提交3：已审批4：已驳回
     */
    public String getpStatus() {
        return pStatus;
    }

    /**
     * 设置 问题状态1：草稿2：已提交3：已审批4：已驳回 字段:problem.p_status
     *
     * @param pStatus the value for problem.p_status, 问题状态1：草稿2：已提交3：已审批4：已驳回
     */
    public void setpStatus(String pStatus) {
        this.pStatus = pStatus == null ? null : pStatus.trim();
    }

    /**
     * 获取 问题类型 字段:problem.p_type
     *
     * @return problem.p_type, 问题类型
     */
    public String getpType() {
        return pType;
    }

    /**
     * 设置 问题类型 字段:problem.p_type
     *
     * @param pType the value for problem.p_type, 问题类型
     */
    public void setpType(String pType) {
        this.pType = pType == null ? null : pType.trim();
    }

    /**
     * 获取 问题类型代码 字段:problem.p_type_code
     *
     * @return problem.p_type_code, 问题类型代码
     */
    public Integer getpTypeCode() {
        return pTypeCode;
    }

    /**
     * 设置 问题类型代码 字段:problem.p_type_code
     *
     * @param pTypeCode the value for problem.p_type_code, 问题类型代码
     */
    public void setpTypeCode(Integer pTypeCode) {
        this.pTypeCode = pTypeCode;
    }

    /**
     * 获取 问题关闭状态 字段:problem.p_close_status
     *
     * @return problem.p_close_status, 问题关闭状态
     */
    public String getpCloseStatus() {
        return pCloseStatus;
    }

    /**
     * 设置 问题关闭状态 字段:problem.p_close_status
     *
     * @param pCloseStatus the value for problem.p_close_status, 问题关闭状态
     */
    public void setpCloseStatus(String pCloseStatus) {
        this.pCloseStatus = pCloseStatus == null ? null : pCloseStatus.trim();
    }

    /**
     * 获取 审批驳回的原因 字段:problem.p_rejected_reason
     *
     * @return problem.p_rejected_reason, 审批驳回的原因
     */
    public String getpRejectedReason() {
        return pRejectedReason;
    }

    /**
     * 设置 审批驳回的原因 字段:problem.p_rejected_reason
     *
     * @param pRejectedReason the value for problem.p_rejected_reason, 审批驳回的原因
     */
    public void setpRejectedReason(String pRejectedReason) {
        this.pRejectedReason = pRejectedReason == null ? null : pRejectedReason.trim();
    }

    /**
     * 获取 删除状态1：未删除2：已删除 字段:problem.p_delete_status
     *
     * @return problem.p_delete_status, 删除状态1：未删除2：已删除
     */
    public Integer getpDeleteStatus() {
        return pDeleteStatus;
    }

    /**
     * 设置 删除状态1：未删除2：已删除 字段:problem.p_delete_status
     *
     * @param pDeleteStatus the value for problem.p_delete_status, 删除状态1：未删除2：已删除
     */
    public void setpDeleteStatus(Integer pDeleteStatus) {
        this.pDeleteStatus = pDeleteStatus;
    }

    /**
     * 获取 创建人 字段:problem.p_founder
     *
     * @return problem.p_founder, 创建人
     */
    public String getpFounder() {
        return pFounder;
    }

    /**
     * 设置 创建人 字段:problem.p_founder
     *
     * @param pFounder the value for problem.p_founder, 创建人
     */
    public void setpFounder(String pFounder) {
        this.pFounder = pFounder == null ? null : pFounder.trim();
    }

    /**
     * 获取 问题创建时间 字段:problem.p_create_time
     *
     * @return problem.p_create_time, 问题创建时间
     */
    public Date getpCreateTime() {
        return pCreateTime;
    }

    /**
     * 设置 问题创建时间 字段:problem.p_create_time
     *
     * @param pCreateTime the value for problem.p_create_time, 问题创建时间
     */
    public void setpCreateTime(Date pCreateTime) {
        this.pCreateTime = pCreateTime;
    }
}