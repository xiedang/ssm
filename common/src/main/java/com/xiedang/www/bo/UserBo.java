package com.xiedang.www.bo;

import com.xiedang.www.model.User;
import com.xiedang.www.model.UserInfo;

/**
 * <p>用户业务类</p>
 *
 * @author : 谢当
 * @date : 2018/11/21 15:10
 */
public class UserBo extends User{
    /**
     * 用户信息
     */
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
