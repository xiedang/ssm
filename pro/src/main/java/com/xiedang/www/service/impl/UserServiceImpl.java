package com.xiedang.www.service.impl;

import com.xiedang.www.mapper.UserMapper;
import com.xiedang.www.model.User;
import com.xiedang.www.service.UserService;
import com.xiedang.www.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/2 13:48
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public CommonResult<String> login(User user) {
        CommonResult<String> result= new CommonResult<>(CommonResult.FAILURE_CODE);
        User u = userMapper.selectByUsernameAndPassword(user);
        if (null!=u){
            result.setSuccess(CommonResult.SUCCESS_CODE);
            result.setMessage("登录成功");
        }else {
            result.setMessage("用户名或者密码错误");
        }
        return result;
    }

    @Override
    public List<User> selectAll(User user) {
        return userMapper.selectAll();
    }
}
