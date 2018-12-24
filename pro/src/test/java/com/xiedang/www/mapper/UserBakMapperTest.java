package com.xiedang.www.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/12/24 15:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-core.xml"})
public class UserBakMapperTest {

    @Autowired
    private UserBakMapper userBakMapper;
    @Test
    public void deleteAll() throws Exception {
        userBakMapper.deleteAll();
    }

}