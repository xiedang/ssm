package com.xiedang.www.model;

/**
 * 
 * UserBak
 * 数据库表：user_bak
 */
public class UserBak {

    /**
     * 
     * 表字段 : user_bak.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : user_bak.username
     */
    private String username;

    /**
     * 
     * 表字段 : user_bak.password
     */
    private String password;

    /**
     * 
     * 表字段 : user_bak.status
     */
    private Integer status;

    /**
     * 获取  字段:user_bak.id
     *
     * @return user_bak.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:user_bak.id
     *
     * @param id the value for user_bak.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:user_bak.username
     *
     * @return user_bak.username, 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置  字段:user_bak.username
     *
     * @param username the value for user_bak.username, 
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取  字段:user_bak.password
     *
     * @return user_bak.password, 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置  字段:user_bak.password
     *
     * @param password the value for user_bak.password, 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取  字段:user_bak.status
     *
     * @return user_bak.status, 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置  字段:user_bak.status
     *
     * @param status the value for user_bak.status, 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}