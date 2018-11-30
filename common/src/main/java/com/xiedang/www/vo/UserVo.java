package com.xiedang.www.vo;

import com.xiedang.www.model.UserInfo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * user查询
 * @Author: Mr.Michelle
 * @date: 上午 10:33 2018/11/24 0024
 */
public class UserVo extends UserInfo{

    private Integer id;

    private String username;

    private String password;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @Override
    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

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
