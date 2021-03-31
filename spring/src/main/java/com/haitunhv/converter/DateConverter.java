package com.haitunhv.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: haitunhv
 * @Date: 2021/3/29 21:31
 */
public class DateConverter implements Converter<String, Date> {
    private String frm;

    public void setFrm(String frm) {
        this.frm = frm;
    }

    @Override
    public Date convert(String s) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(frm);
            return format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
