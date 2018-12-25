package com.xiedang.www.utils.str;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/12/25 14:23
 */
public class StrUtil {
    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     * @param code
     * @return
     */
    public static String autoGenericCode(int code, int num) {
        String result;
        result = String.format("%0" + num + "d", code + 1);
        return result;
    }
}
