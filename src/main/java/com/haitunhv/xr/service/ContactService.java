package com.haitunhv.xr.service;

import com.haitunhv.xr.bean.Contact;
import com.haitunhv.xr.bean.vo.ContactListParam;
import com.haitunhv.xr.bean.vo.ContactListResult;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:16
 */
public interface ContactService extends BaseService<Contact> {
    ContactListResult list(ContactListParam param);
}
