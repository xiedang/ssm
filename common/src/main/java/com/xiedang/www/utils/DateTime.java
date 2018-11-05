package com.xiedang.www.utils;

import java.util.Date;

/**
 * <P>对Date的封装</P>
 *
 * @author 陶焕(13294175866)
 * @date 2016年3月1日 下午5:33:11
 */
public class DateTime extends Date {
    private static final long serialVersionUID = -5395712593979185936L;

    /**
     * 转换JDK date为 DateTime
     *
     * @param date JDK Date
     * @return DateTime
     */
    public static DateTime parse(Date date) {
        return new DateTime(date);
    }

    /**
     * 当前时间
     */
    public DateTime() {
        super();
    }

    /**
     * 给定日期的构造
     *
     * @param date 日期
     */
    public DateTime(Date date) {
        this(date.getTime());
    }

    /**
     * 给定日期毫秒数的构造
     *
     * @param timeMillis 日期毫秒数
     */
    public DateTime(long timeMillis) {
        super(timeMillis);
    }

    @Override
    public String toString() {
        return DateUtils.formatDateTime(this);
    }

    public String toString(String format) {
        return DateUtils.format(this, format);
    }

    /**
     * @return 输出精确到毫秒的标准日期形式
     */
    public String toMsStr() {
        return DateUtils.format(this, DateUtils.NORM_DATETIME_MS_PATTERN);
    }

    /**
     * <p>向上转型成Date,mybatis传递参数时,直接传DateTime有时会出错</p>
     *
     * @return
     * @author 陶焕(13294175866)
     */
    public Date upToDate() {
        Date date = new Date(this.getTime());
        return date;
    }

}