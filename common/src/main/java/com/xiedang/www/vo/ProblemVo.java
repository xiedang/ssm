package com.xiedang.www.vo;

import com.xiedang.www.model.Problem;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: Mr.zyk
 * @Description: ${页面传递到后台数据封装}
 * @Date: 2018/12/22 12:21
 */
public class ProblemVo extends Problem {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pCreateTime;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

    @Override
    public Date getpCreateTime() {
        return pCreateTime;
    }

    @Override
    public void setpCreateTime(Date pCreateTime) {
        this.pCreateTime = pCreateTime;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Integer getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getItemResponsible() {
        return itemResponsible;
    }

    public void setItemResponsible(String itemResponsible) {
        this.itemResponsible = itemResponsible;
    }

    public Date getItemPlanTime() {
        return itemPlanTime;
    }

    public void setItemPlanTime(Date itemPlanTime) {
        this.itemPlanTime = itemPlanTime;
    }

    public String getItemReason() {
        return itemReason;
    }

    public void setItemReason(String itemReason) {
        this.itemReason = itemReason;
    }

    public String getItemMeasure() {
        return itemMeasure;
    }

    public void setItemMeasure(String itemMeasure) {
        this.itemMeasure = itemMeasure;
    }
}
