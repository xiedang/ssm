package com.xiedang.www.model;

import java.util.Date;

/**
 * 
 * Problem
 * 数据库表：problem_lists
 */
public class Problem {

    /**
     * 
     * 表字段 : problem_lists.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : problem_lists.p_no
     */
    private String pNo;

    /**
     * 
     * 表字段 : problem_lists.p_title
     */
    private String pTitle;

    /**
     * 
     * 表字段 : problem_lists.p_type
     */
    private String pType;

    /**
     * 
     * 表字段 : problem_lists.p_type_code
     */
    private Integer pTypeCode;

    /**
     * 
     * 表字段 : problem_lists.p_person
     */
    private String pPerson;

    /**
     * 
     * 表字段 : problem_lists.p_add_time
     */
    private Date pAddTime;

    /**
     * 
     * 表字段 : problem_lists.p_describe
     */
    private String pDescribe;

    /**
     * 
     * 表字段 : problem_lists.p_responsible
     */
    private String pResponsible;

    /**
     * 
     * 表字段 : problem_lists.p_plan_time
     */
    private Date pPlanTime;

    /**
     * 
     * 表字段 : problem_lists.p_measure
     */
    private String pMeasure;

    /**
     * 
     * 表字段 : problem_lists.p_status
     */
    private String pStatus;

    /**
     * 获取  字段:problem_lists.id
     *
     * @return problem_lists.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:problem_lists.id
     *
     * @param id the value for problem_lists.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:problem_lists.p_no
     *
     * @return problem_lists.p_no, 
     */
    public String getpNo() {
        return pNo;
    }

    /**
     * 设置  字段:problem_lists.p_no
     *
     * @param pNo the value for problem_lists.p_no, 
     */
    public void setpNo(String pNo) {
        this.pNo = pNo == null ? null : pNo.trim();
    }

    /**
     * 获取  字段:problem_lists.p_title
     *
     * @return problem_lists.p_title, 
     */
    public String getpTitle() {
        return pTitle;
    }

    /**
     * 设置  字段:problem_lists.p_title
     *
     * @param pTitle the value for problem_lists.p_title, 
     */
    public void setpTitle(String pTitle) {
        this.pTitle = pTitle == null ? null : pTitle.trim();
    }

    /**
     * 获取  字段:problem_lists.p_type
     *
     * @return problem_lists.p_type, 
     */
    public String getpType() {
        return pType;
    }

    /**
     * 设置  字段:problem_lists.p_type
     *
     * @param pType the value for problem_lists.p_type, 
     */
    public void setpType(String pType) {
        this.pType = pType == null ? null : pType.trim();
    }

    /**
     * 获取  字段:problem_lists.p_type_code
     *
     * @return problem_lists.p_type_code, 
     */
    public Integer getpTypeCode() {
        return pTypeCode;
    }

    /**
     * 设置  字段:problem_lists.p_type_code
     *
     * @param pTypeCode the value for problem_lists.p_type_code, 
     */
    public void setpTypeCode(Integer pTypeCode) {
        this.pTypeCode = pTypeCode;
    }

    /**
     * 获取  字段:problem_lists.p_person
     *
     * @return problem_lists.p_person, 
     */
    public String getpPerson() {
        return pPerson;
    }

    /**
     * 设置  字段:problem_lists.p_person
     *
     * @param pPerson the value for problem_lists.p_person, 
     */
    public void setpPerson(String pPerson) {
        this.pPerson = pPerson == null ? null : pPerson.trim();
    }

    /**
     * 获取  字段:problem_lists.p_add_time
     *
     * @return problem_lists.p_add_time, 
     */
    public Date getpAddTime() {
        return pAddTime;
    }

    /**
     * 设置  字段:problem_lists.p_add_time
     *
     * @param pAddTime the value for problem_lists.p_add_time, 
     */
    public void setpAddTime(Date pAddTime) {
        this.pAddTime = pAddTime;
    }

    /**
     * 获取  字段:problem_lists.p_describe
     *
     * @return problem_lists.p_describe, 
     */
    public String getpDescribe() {
        return pDescribe;
    }

    /**
     * 设置  字段:problem_lists.p_describe
     *
     * @param pDescribe the value for problem_lists.p_describe, 
     */
    public void setpDescribe(String pDescribe) {
        this.pDescribe = pDescribe == null ? null : pDescribe.trim();
    }

    /**
     * 获取  字段:problem_lists.p_responsible
     *
     * @return problem_lists.p_responsible, 
     */
    public String getpResponsible() {
        return pResponsible;
    }

    /**
     * 设置  字段:problem_lists.p_responsible
     *
     * @param pResponsible the value for problem_lists.p_responsible, 
     */
    public void setpResponsible(String pResponsible) {
        this.pResponsible = pResponsible == null ? null : pResponsible.trim();
    }

    /**
     * 获取  字段:problem_lists.p_plan_time
     *
     * @return problem_lists.p_plan_time, 
     */
    public Date getpPlanTime() {
        return pPlanTime;
    }

    /**
     * 设置  字段:problem_lists.p_plan_time
     *
     * @param pPlanTime the value for problem_lists.p_plan_time, 
     */
    public void setpPlanTime(Date pPlanTime) {
        this.pPlanTime = pPlanTime;
    }

    /**
     * 获取  字段:problem_lists.p_measure
     *
     * @return problem_lists.p_measure, 
     */
    public String getpMeasure() {
        return pMeasure;
    }

    /**
     * 设置  字段:problem_lists.p_measure
     *
     * @param pMeasure the value for problem_lists.p_measure, 
     */
    public void setpMeasure(String pMeasure) {
        this.pMeasure = pMeasure == null ? null : pMeasure.trim();
    }

    /**
     * 获取  字段:problem_lists.p_status
     *
     * @return problem_lists.p_status, 
     */
    public String getpStatus() {
        return pStatus;
    }

    /**
     * 设置  字段:problem_lists.p_status
     *
     * @param pStatus the value for problem_lists.p_status, 
     */
    public void setpStatus(String pStatus) {
        this.pStatus = pStatus == null ? null : pStatus.trim();
    }
}