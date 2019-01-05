package com.xiedang.www.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 
 * ProblemItem
 * 数据库表：problem_item
 * @author zyk
 */
public class ProblemItem {

    /**
     * 问题项id
     * 表字段 : problem_item.id
     */
    private Integer id;

    /**
     * 外键，问题总表的id
     * 表字段 : problem_item.pid
     */
    private Integer pid;

    /**
     * 问题项描述
     * 表字段 : problem_item.item_desc
     */
    private String itemDesc;

    /**
     * 问题项状态1：草稿2：已提交3：已审批4：已驳回
     * 表字段 : problem_item.item_status
     */
    private Integer itemStatus;

    /**
     * 问题项责任人
     * 表字段 : problem_item.item_responsible
     */
    private String itemResponsible;

    /**
     * 问题项计划完成日期
     * 表字段 : problem_item.item_plan_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date itemPlanTime;

    /**
     * 问题项驳回原因
     * 表字段 : problem_item.item_reason
     */
    private String itemReason;

    /**
     * 问题项措施
     * 表字段 : problem_item.item_measure
     */
    private String itemMeasure;

    /**
     * 获取 问题项id 字段:problem_item.id
     *
     * @return problem_item.id, 问题项id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 问题项id 字段:problem_item.id
     *
     * @param id the value for problem_item.id, 问题项id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 外键，问题总表的id 字段:problem_item.pid
     *
     * @return problem_item.pid, 外键，问题总表的id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置 外键，问题总表的id 字段:problem_item.pid
     *
     * @param pid the value for problem_item.pid, 外键，问题总表的id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取 问题项描述 字段:problem_item.item_desc
     *
     * @return problem_item.item_desc, 问题项描述
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * 设置 问题项描述 字段:problem_item.item_desc
     *
     * @param itemDesc the value for problem_item.item_desc, 问题项描述
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    /**
     * 获取 问题项状态1：草稿2：已提交3：已审批4：已驳回 字段:problem_item.item_status
     *
     * @return problem_item.item_status, 问题项状态1：草稿2：已提交3：已审批4：已驳回
     */
    public Integer getItemStatus() {
        return itemStatus;
    }

    /**
     * 设置 问题项状态1：草稿2：已提交3：已审批4：已驳回 字段:problem_item.item_status
     *
     * @param itemStatus the value for problem_item.item_status, 问题项状态1：草稿2：已提交3：已审批4：已驳回
     */
    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    /**
     * 获取 问题项责任人 字段:problem_item.item_responsible
     *
     * @return problem_item.item_responsible, 问题项责任人
     */
    public String getItemResponsible() {
        return itemResponsible;
    }

    /**
     * 设置 问题项责任人 字段:problem_item.item_responsible
     *
     * @param itemResponsible the value for problem_item.item_responsible, 问题项责任人
     */
    public void setItemResponsible(String itemResponsible) {
        this.itemResponsible = itemResponsible == null ? null : itemResponsible.trim();
    }

    /**
     * 获取 问题项计划完成日期 字段:problem_item.item_plan_time
     *
     * @return problem_item.item_plan_time, 问题项计划完成日期
     */
    public Date getItemPlanTime() {
        return itemPlanTime;
    }

    /**
     * 设置 问题项计划完成日期 字段:problem_item.item_plan_time
     *
     * @param itemPlanTime the value for problem_item.item_plan_time, 问题项计划完成日期
     */
    public void setItemPlanTime(Date itemPlanTime) {
        this.itemPlanTime = itemPlanTime;
    }

    /**
     * 获取 问题项驳回原因 字段:problem_item.item_reason
     *
     * @return problem_item.item_reason, 问题项驳回原因
     */
    public String getItemReason() {
        return itemReason;
    }

    /**
     * 设置 问题项驳回原因 字段:problem_item.item_reason
     *
     * @param itemReason the value for problem_item.item_reason, 问题项驳回原因
     */
    public void setItemReason(String itemReason) {
        this.itemReason = itemReason == null ? null : itemReason.trim();
    }

    /**
     * 获取 问题项措施 字段:problem_item.item_measure
     *
     * @return problem_item.item_measure, 问题项措施
     */
    public String getItemMeasure() {
        return itemMeasure;
    }

    /**
     * 设置 问题项措施 字段:problem_item.item_measure
     *
     * @param itemMeasure the value for problem_item.item_measure, 问题项措施
     */
    public void setItemMeasure(String itemMeasure) {
        this.itemMeasure = itemMeasure == null ? null : itemMeasure.trim();
    }
}