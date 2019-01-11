package com.xiedang.www.task;

import com.xiedang.www.mapper.UserBakMapper;
import com.xiedang.www.mapper.UserMapper;
import com.xiedang.www.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class BackupTask {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBakMapper userBakMapper;

    @Scheduled(cron = "0 0 0 * * ?")
    public void sqlBackUp(){
        log.info("调用定时器备份数据");
        backUp();
    }

    public void backUp(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        userBakMapper.deleteAll();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        try {
            for (int i = 0; i < 5; i++) {
                int j = i;
                cachedThreadPool.execute(() -> {
                    try {
                        Map<String,Object> map=new HashMap<>(2);
                        int size=2;
                        map.put("start",j*size);
                        map.put("size",size);
                        List<User> users = userMapper.selectUserByPage(map);
                        start.await();
                        if(null!=users && users.size()>0) {
                            userBakMapper.batchInsert(users);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        end.countDown();
                    }
                });
            }
            cachedThreadPool.execute(start::countDown);
            end.await();
            log.info("备份完成");
            cachedThreadPool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
