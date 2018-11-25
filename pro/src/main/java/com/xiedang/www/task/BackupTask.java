package com.xiedang.www.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BackupTask {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 0 20 * * ?")
    public void sqlBackUp(){
       log.info("调用定时器备份数据");
    }
}
