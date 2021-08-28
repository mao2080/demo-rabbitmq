package com.demo.rabbitmq.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author mao2080@sina.com
 */
public class CommonUtil {

    /**
     * 日期格式yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss.SSSSSS";

    /**
     * 描述：获取当前时间
     * @return yyyy-MM-dd HH:mm:ss格式字符串
     * @author mao2080@sina.com
     * @created 2017年3月20日 下午2:20:03
     * @since
     */
    public static String getNowTime() {
        return format(Calendar.getInstance(), YYYYMMDDHHMMSS);
    }

    /**
     * 描述：将Calendar格式化成字符串
     * @param cal     Calendar时间
     * @param pattern 时间格式
     * @return 自定义格式字符串
     * @author mao2080@sina.com
     * @created 2017年3月20日 下午2:20:03
     * @since
     */
    public static String format(Calendar cal, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}