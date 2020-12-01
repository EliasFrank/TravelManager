package com.hl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hl2333
 */
public class DateUtils {

    /**
     * 将日期转换为字符串
     * @param date 传入的日期
     * @param pattern 需要转换的日期格式
     * @return 指定格式的日期
     */
    public static String dateToString(Date date, String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String time = simpleDateFormat.format(date);

        return time;
    }

    /**
     * 将传入的字符串转换为日期
     * @param str 传入的字符串
     * @param pattern 日期格式
     * @return 根据字符串获得的日期
     * @throws ParseException 解析异常
     */
    public static Date stringToDate(String str, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(str);
        return date;
    }
}
