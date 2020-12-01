package com.hl.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

/**
 * @author hl2333
 */
public class Str2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        Date time = null;
        try {
            time = DateUtils.stringToDate(source, "yyyy-MM-dd HH:mm");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
