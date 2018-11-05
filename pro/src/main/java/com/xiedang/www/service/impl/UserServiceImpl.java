package com.xiedang.www.service.impl;

import com.xiedang.www.mapper.UserMapper;
import com.xiedang.www.model.User;
import com.xiedang.www.service.UserService;
import com.xiedang.www.utils.CommonResult;
import com.xiedang.www.utils.ExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
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
    public boolean login(User user) {
        boolean b=false;
        User u = userMapper.selectByUsernameAndPassword(user);
        if (null!=u){
            b=true;
            user.setId(u.getId());
        }
        return  b;
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> exportExcel(HttpServletResponse response) {
        List<User> users = userMapper.selectAll();
        String titles[]={"ID","用户名","密码"};
        String columns[]={"id","username","password"};
        ExportUtil.export(titles,columns,users,"系统用户表","系统用户表",response);
        return null;
    }
}
