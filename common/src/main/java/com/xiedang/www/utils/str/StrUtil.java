package com.xiedang.www.utils.str;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/12/25 14:23
 */
public class StrUtil {

    private static Pattern pattern = Pattern.compile("^\\$\\{[A-Za-z_]?[A-Za-z\\d]*}$");

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *  例如 （1,4）-> 0002
     * @param code  数值
     * @param num   位数
     * @return
     */
    public static String autoGenericCode(int code, int num) {
        String result;
        result = String.format("%0" + num + "d", code + 1);
        return result;
    }

    /**
     * 用map.get(key)替换字符串中的${key}
     *
     * @param msg
     * @param map
     * @return
     */
    public static String replace(String msg, Map<String, String> map) {
        if(StringUtils.isNotBlank(msg)) {
            if(map==null){
                return msg;
            }
            StringBuilder result = new StringBuilder();
            int start = 0;
            int end = -1;
            int lastEnd = -1;
            while (start != -1) {
                start = msg.indexOf('$', end + 1);
                if (start != -1 && '{' == msg.charAt(start + 1)) {
                    //防止出现${}这样的字符串搜索从开始点加2开始算
                    end = msg.indexOf('}', start + 2);
                    if (end != -1) {
                        //获取key
                        String key = msg.substring(start + 2, end);
                        //获取key对应的value
                        String value = map.get(key);
                        if (null != value) {
                            result.append(msg.substring(lastEnd + 1, start)).append(value);
                        }
                    }
                    lastEnd = end;
                }
            }
            result.append(msg.substring(end + 1, msg.length()));
            return result.toString();
        }

        return null;

    }

    /**
     * 获取一个字符串的简明效果
     *
     * @return String 返回的字符串格式类似于"abcd***hijk"
     */
    public static String getStringSimple(String data) {
        return data.substring(0, 4) + "***" + data.substring(data.length() - 4);
    }

    /**
     * 获取系统流水号
     *
     * @param length   指定流水号长度
     * @param isNumber 指定流水号是否全由数字组成
     */
    public static String getSysJournalNo(int length, boolean isNumber) {
        //replaceAll()之后返回的是一个由十六进制形式组成的且长度为32的字符串
        StringBuilder uuid = new StringBuilder(UUID.randomUUID().toString().replaceAll("-", ""));
        if (uuid.length() > length) {
            uuid = new StringBuilder(uuid.substring(0, length));
        } else if (uuid.length() < length) {
            for (int i = 0; i < length - uuid.length(); i++) {
                uuid.append(Math.round(Math.random() * 9));
            }
        }
        if (isNumber) {
            return uuid.toString().replaceAll("a", "1").replaceAll("b", "2").replaceAll("c", "3").replaceAll("d", "4").replaceAll("e", "5").replaceAll("f", "6");
        } else {
            return uuid.toString();
        }
    }

    public static void main(String[] args) {
        String s = "1${b}2${a}3${c}4${b}5${a}6${b}7${a}8";
        Map<String, String> map = new HashMap<>(16);
        map.put("a", "你好");
        map.put("b", "我好");
        map.put("c", "他好");
        String replace = replace(s, map);
        System.out.println(replace);
    }
}
