package com.xiedang.www.service;

import com.xiedang.www.bo.UserBo;
import com.xiedang.www.model.User;
import com.xiedang.www.utils.CommonResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/11/2 13:29
 */
public interface UserService {
    /**
     * 用户登录
     * @param username
     * @return
     */
    User login(String username);

    /**
     * 查询所有用户
     * @return
     */
    List<UserBo> selectAll();

    /**
     * 导出用户excel
     * @return
     */
    List<UserBo> exportExcel(HttpServletResponse response);
}
