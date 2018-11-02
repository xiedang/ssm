package com.xiedang.www.model;

import java.math.BigDecimal;

/**
 * 公司表
 * Company
 * 数据库表：company
 */
public class Company {

    /**
     * 供应商ID
     * 表字段 : company.COMPANY_ID
     */
    private String companyId;

    /**
     * 供应商公司名称
     * 表字段 : company.COMPANY_NAME
     */
    private String companyName;

    /**
     * 公司简称
     * 表字段 : company.SHORTTHAND
     */
    private String shortthand;

    /**
     * 公司编号
     * 表字段 : company.COMPANY_NO
     */
    private String companyNo;

    /**
     * 公司联系方式
     * 表字段 : company.COMPANY_PHONE
     */
    private String companyPhone;

    /**
     * 公司地址
     * 表字段 : company.COMPANY_ADDRESS
     */
    private String companyAddress;

    /**
     * 企业联系人
     * 表字段 : company.CONTACTS
     */
    private String contacts;

    /**
     * 备注
     * 表字段 : company.REMARKS
     */
    private String remarks;

    /**
     * 1-正常,2-删除
     * 表字段 : company.COM_STATUS
     */
    private BigDecimal comStatus;

    /**
     * 传真
     * 表字段 : company.COMPANY_FAX
     */
    private String companyFax;

    /**
     * 业务经理联系人
     * 表字段 : company.operation_manager_name
     */
    private String operationManagerName;

    /**
     * 业务经理联系方式
     * 表字段 : company.operation_manager_phone
     */
    private String operationManagerPhone;

    /**
     * 获取 供应商ID 字段:company.COMPANY_ID
     *
     * @return company.COMPANY_ID, 供应商ID
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 设置 供应商ID 字段:company.COMPANY_ID
     *
     * @param companyId the value for company.COMPANY_ID, 供应商ID
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * 获取 供应商公司名称 字段:company.COMPANY_NAME
     *
     * @return company.COMPANY_NAME, 供应商公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置 供应商公司名称 字段:company.COMPANY_NAME
     *
     * @param companyName the value for company.COMPANY_NAME, 供应商公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取 公司简称 字段:company.SHORTTHAND
     *
     * @return company.SHORTTHAND, 公司简称
     */
    public String getShortthand() {
        return shortthand;
    }

    /**
     * 设置 公司简称 字段:company.SHORTTHAND
     *
     * @param shortthand the value for company.SHORTTHAND, 公司简称
     */
    public void setShortthand(String shortthand) {
        this.shortthand = shortthand == null ? null : shortthand.trim();
    }

    /**
     * 获取 公司编号 字段:company.COMPANY_NO
     *
     * @return company.COMPANY_NO, 公司编号
     */
    public String getCompanyNo() {
        return companyNo;
    }

    /**
     * 设置 公司编号 字段:company.COMPANY_NO
     *
     * @param companyNo the value for company.COMPANY_NO, 公司编号
     */
    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo == null ? null : companyNo.trim();
    }

    /**
     * 获取 公司联系方式 字段:company.COMPANY_PHONE
     *
     * @return company.COMPANY_PHONE, 公司联系方式
     */
    public String getCompanyPhone() {
        return companyPhone;
    }

    /**
     * 设置 公司联系方式 字段:company.COMPANY_PHONE
     *
     * @param companyPhone the value for company.COMPANY_PHONE, 公司联系方式
     */
    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone == null ? null : companyPhone.trim();
    }

    /**
     * 获取 公司地址 字段:company.COMPANY_ADDRESS
     *
     * @return company.COMPANY_ADDRESS, 公司地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置 公司地址 字段:company.COMPANY_ADDRESS
     *
     * @param companyAddress the value for company.COMPANY_ADDRESS, 公司地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    /**
     * 获取 企业联系人 字段:company.CONTACTS
     *
     * @return company.CONTACTS, 企业联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置 企业联系人 字段:company.CONTACTS
     *
     * @param contacts the value for company.CONTACTS, 企业联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * 获取 备注 字段:company.REMARKS
     *
     * @return company.REMARKS, 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置 备注 字段:company.REMARKS
     *
     * @param remarks the value for company.REMARKS, 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取 1-正常,2-删除 字段:company.COM_STATUS
     *
     * @return company.COM_STATUS, 1-正常,2-删除
     */
    public BigDecimal getComStatus() {
        return comStatus;
    }

    /**
     * 设置 1-正常,2-删除 字段:company.COM_STATUS
     *
     * @param comStatus the value for company.COM_STATUS, 1-正常,2-删除
     */
    public void setComStatus(BigDecimal comStatus) {
        this.comStatus = comStatus;
    }

    /**
     * 获取 传真 字段:company.COMPANY_FAX
     *
     * @return company.COMPANY_FAX, 传真
     */
    public String getCompanyFax() {
        return companyFax;
    }

    /**
     * 设置 传真 字段:company.COMPANY_FAX
     *
     * @param companyFax the value for company.COMPANY_FAX, 传真
     */
    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax == null ? null : companyFax.trim();
    }

    /**
     * 获取 业务经理联系人 字段:company.operation_manager_name
     *
     * @return company.operation_manager_name, 业务经理联系人
     */
    public String getOperationManagerName() {
        return operationManagerName;
    }

    /**
     * 设置 业务经理联系人 字段:company.operation_manager_name
     *
     * @param operationManagerName the value for company.operation_manager_name, 业务经理联系人
     */
    public void setOperationManagerName(String operationManagerName) {
        this.operationManagerName = operationManagerName == null ? null : operationManagerName.trim();
    }

    /**
     * 获取 业务经理联系方式 字段:company.operation_manager_phone
     *
     * @return company.operation_manager_phone, 业务经理联系方式
     */
    public String getOperationManagerPhone() {
        return operationManagerPhone;
    }

    /**
     * 设置 业务经理联系方式 字段:company.operation_manager_phone
     *
     * @param operationManagerPhone the value for company.operation_manager_phone, 业务经理联系方式
     */
    public void setOperationManagerPhone(String operationManagerPhone) {
        this.operationManagerPhone = operationManagerPhone == null ? null : operationManagerPhone.trim();
    }
}