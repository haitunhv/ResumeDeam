package com.haitunhv.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Author: haitunhv
 * @Date: 2021/4/14 21:12
 */
@Component
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        try {
            return new SimpleDateFormat("yyyy-mm-dd").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
