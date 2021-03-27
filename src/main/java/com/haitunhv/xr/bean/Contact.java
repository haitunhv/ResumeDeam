package com.haitunhv.xr.bean;

import com.haitunhv.xr.bean.base.BaseBean;

/**
 * @Author: haitunhv
 * @Date: 2021/3/15 23:44
 */
public class Contact extends BaseBean {
    private String name;
    private String email;
    private String comment;
    private String subject;
    private Boolean alreadyRead = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getAlreadyRead() {
        return alreadyRead;
    }

    public void setAlreadyRead(Boolean alreadyRead) {
        this.alreadyRead = alreadyRead;
    }
}
