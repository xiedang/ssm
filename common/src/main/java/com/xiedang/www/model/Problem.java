package com.xiedang.www.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 
 * Problem
 * 数据库表：problem
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
     * 问题发现时间
     * 表字段 : problem.p_find_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date pFindTime;

    /**
     * 问题提出人
     * 表字段 : problem.p_person
     */
    private String pPerson;

    /**
     * 责任人
     * 表字段 : problem.p_responsible
     */
    private String pResponsible;

    /**
     * 计划完成日期
     * 表字段 : problem.p_plan_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date pPlanTime;

    /**
     * 问题描述
     * 表字段 : problem.p_describe
     */
    private String pDescribe;

    /**
     * 备注
     * 表字段 : problem.p_remark
     */
    private String pRemark;

    /**
     * 问题状态
     * 表字段 : problem.p_status
     */
    private String pStatus;

    /**
     * 删除状态
        1：未删除
        2：已删除
     * 表字段 : problem.p_delete_status
     */
    private Integer pDeleteStatus;

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
        this.pNo = pNo;
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
     * 获取 问题发现时间 字段:problem.p_find_time
     *
     * @return problem.p_find_time, 问题发现时间
     */
    public Date getpFindTime() {
        return pFindTime;
    }

    /**
     * 设置 问题发现时间 字段:problem.p_find_time
     *
     * @param pFindTime the value for problem.p_find_time, 问题发现时间
     */
    public void setpFindTime(Date pFindTime) {
        this.pFindTime = pFindTime;
    }

    /**
     * 获取 问题提出人 字段:problem.p_person
     *
     * @return problem.p_person, 问题提出人
     */
    public String getpPerson() {
        return pPerson;
    }

    /**
     * 设置 问题提出人 字段:problem.p_person
     *
     * @param pPerson the value for problem.p_person, 问题提出人
     */
    public void setpPerson(String pPerson) {
        this.pPerson = pPerson == null ? null : pPerson.trim();
    }

    /**
     * 获取 责任人 字段:problem.p_responsible
     *
     * @return problem.p_responsible, 责任人
     */
    public String getpResponsible() {
        return pResponsible;
    }

    /**
     * 设置 责任人 字段:problem.p_responsible
     *
     * @param pResponsible the value for problem.p_responsible, 责任人
     */
    public void setpResponsible(String pResponsible) {
        this.pResponsible = pResponsible == null ? null : pResponsible.trim();
    }

    /**
     * 获取 计划完成日期 字段:problem.p_plan_time
     *
     * @return problem.p_plan_time, 计划完成日期
     */
    public Date getpPlanTime() {
        return pPlanTime;
    }

    /**
     * 设置 计划完成日期 字段:problem.p_plan_time
     *
     * @param pPlanTime the value for problem.p_plan_time, 计划完成日期
     */
    public void setpPlanTime(Date pPlanTime) {
        this.pPlanTime = pPlanTime;
    }

    /**
     * 获取 问题描述 字段:problem.p_describe
     *
     * @return problem.p_describe, 问题描述
     */
    public String getpDescribe() {
        return pDescribe;
    }

    /**
     * 设置 问题描述 字段:problem.p_describe
     *
     * @param pDescribe the value for problem.p_describe, 问题描述
     */
    public void setpDescribe(String pDescribe) {
        this.pDescribe = pDescribe == null ? null : pDescribe.trim();
    }

    /**
     * 获取 备注 字段:problem.p_remark
     *
     * @return problem.p_remark, 备注
     */
    public String getpRemark() {
        return pRemark;
    }

    /**
     * 设置 备注 字段:problem.p_remark
     *
     * @param pRemark the value for problem.p_remark, 备注
     */
    public void setpRemark(String pRemark) {
        this.pRemark = pRemark == null ? null : pRemark.trim();
    }

    /**
     * 获取 问题状态 字段:problem.p_status
     *
     * @return problem.p_status, 问题状态
     */
    public String getpStatus() {
        return pStatus;
    }

    /**
     * 设置 问题状态 字段:problem.p_status
     *
     * @param pStatus the value for problem.p_status, 问题状态
     */
    public void setpStatus(String pStatus) {
        this.pStatus = pStatus == null ? null : pStatus.trim();
    }

    /**
     * 获取 删除状态
        1：未删除
        2：已删除 字段:problem.p_delete_status
     *
     * @return problem.p_delete_status, 删除状态
        1：未删除
        2：已删除
     */
    public Integer getpDeleteStatus() {
        return pDeleteStatus;
    }

    /**
     * 设置 删除状态
        1：未删除
        2：已删除 字段:problem.p_delete_status
     *
     * @param pDeleteStatus the value for problem.p_delete_status, 删除状态
        1：未删除
        2：已删除
     */
    public void setpDeleteStatus(Integer pDeleteStatus) {
        this.pDeleteStatus = pDeleteStatus;
    }
}