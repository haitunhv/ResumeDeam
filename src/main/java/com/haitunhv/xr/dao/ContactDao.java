package com.haitunhv.xr.dao;

import com.haitunhv.xr.bean.Contact;
import com.haitunhv.xr.bean.vo.ContactListParam;
import com.haitunhv.xr.bean.vo.ContactListResult;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:09
 */
public interface ContactDao extends BaseDao<Contact> {
    ContactListResult list(ContactListParam param);
}
