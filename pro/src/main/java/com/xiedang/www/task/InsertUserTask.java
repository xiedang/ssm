package com.xiedang.www.task;

import com.xiedang.www.mapper.UserBakMapper;
import com.xiedang.www.mapper.UserMapper;
import com.xiedang.www.model.User;
import com.xiedang.www.utils.str.ShareCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class InsertUserTask {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBakMapper userBakMapper;

    @Scheduled(cron = "0 0 2 * * ?")
    public void insertUser() {
        log.info("调用定时器添加数据");
        insert();
    }

    public void insert() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        userBakMapper.deleteAll();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(10);
        try {
            for (int i = 0; i < 10; i++) {
                cachedThreadPool.execute(() -> {
                    try {
                        start.await();
                        for (int j = 0; j < 5; j++) {
                            List<User> users = new ArrayList<>();
                            for (int k = 0; k < 20000; k++) {
                                User user = new User();
                                user.setUsername(ShareCodeUtil.toSerialCode(j));
                                user.setPassword(ShareCodeUtil.toSerialCode(j));
                                user.setStatus(1);
                                users.add(user);
                            }
                            userMapper.batchInsert(users);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                });
            }
            cachedThreadPool.execute(start::countDown);
            end.await();
            log.info("插入完成");
            cachedThreadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
