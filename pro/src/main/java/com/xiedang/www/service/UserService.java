package com.xiedang.www.service;

import com.xiedang.www.model.User;
import com.xiedang.www.utils.CommonResult;

import java.util.List;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/2 13:29
 */
public interface UserService {
    CommonResult<String> login(User user);

    List<User> selectAll(User user);
}
