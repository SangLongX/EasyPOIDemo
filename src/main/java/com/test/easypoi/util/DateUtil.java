package com.test.easypoi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具
 *
 * @author SangXiaolong
 * @date 2018/11/13 14:12
 */
public class DateUtil {
    private static final String YYY_MM_DD="yyyy-mm-dd";

    /**
     * 返回yyyy-mm-dd格式的时间
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param dateStr : 时间字符串
     * @return : java.util.Date 对应的时间
     * @modifyHistory
     */
    public static Date getLowerYearMonthDay(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(YYY_MM_DD);
        return sdf.parse(dateStr);
    }
}
