package com.haitunhv.xr.bean.vo;

import com.haitunhv.xr.bean.Contact;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/16 23:04
 */
public class ContactListResult extends ContactListParam {
    private Integer totalPages;
    private Integer totalCount;

    List<Contact> contacts;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
