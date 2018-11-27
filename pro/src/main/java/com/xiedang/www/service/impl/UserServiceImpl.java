package com.xiedang.www.service.impl;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.mapper.UserMapper;
import com.xiedang.www.model.User;
import com.xiedang.www.service.UserService;
import com.xiedang.www.utils.ExportUtil;
import com.xiedang.www.vo.UserVo;
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
    public User login(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<UserBo> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<UserBo> queryUser(UserVo userVo) {
        return userMapper.queryUser(userVo);
    }

    @Override
    public List<UserBo> exportExcel(HttpServletResponse response) {
        List<UserBo> userBos = userMapper.selectAll();
        String[] titles={"ID","用户名","密码"};
        String[] columns={"id","username","password"};
        ExportUtil.export(titles,columns,userBos,"系统用户表","系统用户表",response);
        return null;
    }


}
