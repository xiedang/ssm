package com.xiedang.www.vo;

import com.xiedang.www.model.UserInfo;

/**
 * user查询
 * @Author: Mr.Michelle
 * @date: 上午 10:33 2018/11/24 0024
 */
public class UserVo extends UserInfo{

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
