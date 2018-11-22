package com.xiedang.www.model;

/**
 * 
 * User
 * 数据库表：user
 */
public class User {

    /**
     * 
     * 表字段 : user.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : user.username
     */
    private String username;

    /**
     * 
     * 表字段 : user.password
     */
    private String password;

    /**
     * 获取  字段:user.id
     *
     * @return user.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:user.id
     *
     * @param id the value for user.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:user.username
     *
     * @return user.username, 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置  字段:user.username
     *
     * @param username the value for user.username, 
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取  字段:user.password
     *
     * @return user.password, 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置  字段:user.password
     *
     * @param password the value for user.password, 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}