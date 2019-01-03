package com.xiedang.www.service.impl;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.mapper.UserInfoMapper;
import com.xiedang.www.mapper.UserMapper;
import com.xiedang.www.model.User;
import com.xiedang.www.service.UserService;
import com.xiedang.www.utils.date.DateUtil;
import com.xiedang.www.utils.excel.ExportUtil;
import com.xiedang.www.vo.UserVo;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/2 13:48
 */
@Service("logistics.UserServiceImpl")
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
    public List<UserBo> exportExcel(HttpServletResponse response) throws InterruptedException {
        List<UserBo> userBos = userMapper.selectAll();
        XSSFWorkbook wb=new XSSFWorkbook();
        String[] titles={"ID","用户名","密码"};
        String[] columns={"id","username","password"};
        ExecutorService executorService= Executors.newCachedThreadPool();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(4);
        for (int i = 0; i < 4; i++){
            wb.createSheet("系统用户表"+i);
        }
            for (int i = 0; i < 4; i++) {
                int j = i;
                executorService.execute(() -> {
                    try {
                        start.await();
                        ExportUtil.exportWithNotDownload(titles,columns,userBos,wb,wb.getSheetAt(j));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        end.countDown();
                    }
                });
            }
            executorService.execute(start::countDown);
            end.await();
            System.out.println("结束........");
            executorService.shutdown();

        ExportUtil.export(response,wb,"系统用户表");
        return null;
    }

    @Override
    public int addUser(UserVo userVo) {
        return userMapper.insertSelective(userVo) + userInfoMapper.insertSelective(userVo);
    }

    @Override
    public int batchInsert(List<User> users) {
        return userMapper.batchInsert(users);
    }

    @Override
    public int doDeleteUsers(String[] ids) {
        int i = 0;
        try {
            i = userMapper.deleteByPrimaryKey(ids) + userInfoMapper.deleteByPrimaryKey(ids);
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
    public List<UserBo> queryUserByPage(Map<String,Object> map) {
        return userMapper.queryUserByPage(map);
    }

    @Override
    public String getNameByUserName(String username) {
        return userMapper.getNameByUserName(username);
    }

    @Override
    public int batchUpdate(List<User> users) {
        return userMapper.batchUpdate(users);
    }
}
