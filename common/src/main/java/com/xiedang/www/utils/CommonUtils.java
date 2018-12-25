package com.xiedang.www.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/7/30 14:05
 */
public class CommonUtils {
    private static final Logger log = LoggerFactory.getLogger(CommonUtils.class);
    private static final String POSITIVE_INTEGER = "^\\d+$";
    private static final String NUMBER = "^-?\\d+\\.?\\d+$";

    /**
     * 从实体中解析出字段数据
     *
     * @param data  可能为pojo或者map 从field中解析
     * @param field 字段名称
     * @return
     */
    public static Object getValue(Object data, String field) {
        if (data instanceof Map) {
            Map map = (Map) data;
            return map.get(field);
        }
        try {
            String method = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
            Method m = data.getClass().getMethod(method, (Class<?>) null);
            if (m != null) {
                return m.invoke(data, (Object) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("data invoke error , data:" + data + " , key:" + field);
            return null;
        }
        return null;
    }

    /**
     * 判断是否为数字
     *
     * @param v
     * @return
     */
    public static boolean isNumber(Object v) {
        return v != null && (v instanceof Number || v.toString().matches(POSITIVE_INTEGER) || v.toString().matches(NUMBER));
    }

    /**
     * 返回 #{} 中包含的值
     *
     * @param str
     * @return eg:#{name}
     */
    public static String[] getWildcard(String str) {
        List<String> list = new ArrayList<>();
        int start = 0;
        while (start < str.length() && start >= 0) {
            start = str.indexOf("{", start);
            int end = str.indexOf("}", start);
            if (start > 0) {
                String wc = str.substring(start - 1, end + 1);
                list.add(wc);
            }
            if (start < 0) {
                break;
            }
            start = end + 1;
        }
        return list.toArray(new String[0]);
    }
}
