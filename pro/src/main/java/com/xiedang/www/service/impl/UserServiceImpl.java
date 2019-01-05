package com.xiedang.www.service.impl;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.mapper.UserInfoMapper;
import com.xiedang.www.mapper.UserMapper;
import com.xiedang.www.model.User;
import com.xiedang.www.service.UserService;
import com.xiedang.www.utils.ExportUtil;
import com.xiedang.www.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/2 13:48
 */
@Service("logistics.UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public User login(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<UserBo> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> selectAllLoginInfo() {
        return userMapper.selectAllLoginInfo();
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

    @Override
    public int addUser(UserVo userVo) {
        return userMapper.insertSelective(userVo) + userInfoMapper.insertSelective(userVo);
    }

    @Override
    public int doDeleteUser(String key) {
        int i = 0;
        try {
            i = userMapper.deleteByPrimaryKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int doDeleteUsers(String[] ids) {
        int i = 0;
        try {
            i = userMapper.deleteByPrimaryKeys(ids) + userInfoMapper.deleteByPrimaryKey(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int updateUserById(UserVo vo) {
        int i = 0;
        try {
            i = userMapper.updateByPrimaryKeySelective(vo) + userInfoMapper.updateByPrimaryKeySelective(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public UserBo getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserBo> queryUserByPage(Map map) {
        return userMapper.queryUserByPage(map);
    }


}
