package com.xiedang.www.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 用户信息表
 * UserInfo
 * 数据库表：user_info
 */
public class UserInfo {

    /**
     * 
     * 表字段 : user_info.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : user_info.name
     */
    private String name;

    /**
     * 
     * 表字段 : user_info.sex
     */
    private String sex;

    /**
     * 
     * 表字段 : user_info.phone
     */
    private String phone;

    /**
     * 
     * 表字段 : user_info.address
     */
    private String address;

    /**
     * 
     * 表字段 : user_info.birth_date
     */

    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date birthDate;

    /**
     * 
     * 表字段 : user_info.native_place
     */
    private String nativePlace;

    /**
     * 
     * 表字段 : user_info.uid
     */
    private Integer uid;

    /**
     * 
     * 表字段 : user_info.status
     */
    private Integer status;

    /**
     * 获取  字段:user_info.id
     *
     * @return user_info.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:user_info.id
     *
     * @param id the value for user_info.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:user_info.name
     *
     * @return user_info.name, 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  字段:user_info.name
     *
     * @param name the value for user_info.name, 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取  字段:user_info.sex
     *
     * @return user_info.sex, 
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置  字段:user_info.sex
     *
     * @param sex the value for user_info.sex, 
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取  字段:user_info.phone
     *
     * @return user_info.phone, 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置  字段:user_info.phone
     *
     * @param phone the value for user_info.phone, 
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取  字段:user_info.address
     *
     * @return user_info.address, 
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置  字段:user_info.address
     *
     * @param address the value for user_info.address, 
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取  字段:user_info.birth_date
     *
     * @return user_info.birth_date, 
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 设置  字段:user_info.birth_date
     *
     * @param birthDate the value for user_info.birth_date, 
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取  字段:user_info.native_place
     *
     * @return user_info.native_place, 
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置  字段:user_info.native_place
     *
     * @param nativePlace the value for user_info.native_place, 
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    /**
     * 获取  字段:user_info.uid
     *
     * @return user_info.uid, 
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置  字段:user_info.uid
     *
     * @param uid the value for user_info.uid, 
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取  字段:user_info.status
     *
     * @return user_info.status, 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置  字段:user_info.status
     *
     * @param status the value for user_info.status, 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}