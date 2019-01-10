package com.xiedang.www.utils;

import com.alibaba.fastjson.JSONArray;
import com.xiedang.www.utils.date.DateUtil;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/12/19 14:43
 */
public class ThreadTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        try {
            for (int i = 0; i < 5; i++) {
                int j = i;
                executorService.execute(() -> {
                    try {
                        start.await();
                        System.out.println("当前为" + j + "在" + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss:S") + "结束运行");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                });
            }
            executorService.execute(() -> {
                System.out.println("在" + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss:S") + "开始运行");
                start.countDown();
            });
            end.await();
            System.out.println("结束........");
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public static void test() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>(3);
        Map<String, Object> map1 = new HashMap<>(3);
        Map<String, Object> map2 = new HashMap<>(3);
        map2.put("text", "3");
        map2.put("url", "3");
        map1.put("text", "2");
        map1.put("url", "2");
        map1.put("children", map2);
        map.put("text", "1");
        map.put("url", "1");
        map.put("children", map1);
        mapList.add(map);
        System.out.println(JSONArray.toJSON(mapList));
    }
}
