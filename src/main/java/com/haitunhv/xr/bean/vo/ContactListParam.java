package com.haitunhv.xr.bean.vo;

import java.util.Date;

/**
 * @Author: haitunhv
 * @Date: 2021/3/16 21:42
 */
public class ContactListParam {
    public static final Integer READ_ALL = 2;
    private Integer pageNo;
    private Integer pageSize;
    private Date beginDay;
    private Date endDay;
    private String keyWord;
    private Integer alreadyRead;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Date getBeginDay() {
        return beginDay;
    }

    public void setBeginDay(Date beginDay) {
        this.beginDay = beginDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getAlreadyRead() {
        return alreadyRead;
    }

    public void setAlreadyRead(Integer alreadyRead) {
        this.alreadyRead = alreadyRead;
    }
}
