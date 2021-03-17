package com.haitunhv.xr.service.impl;

import com.haitunhv.xr.bean.Contact;
import com.haitunhv.xr.bean.vo.ContactListParam;
import com.haitunhv.xr.bean.vo.ContactListResult;
import com.haitunhv.xr.dao.ContactDao;
import com.haitunhv.xr.service.ContactService;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:16
 */
public class ContactServiceImpl extends BaseServiceImpl<Contact> implements ContactService {
    @Override
    public ContactListResult list(ContactListParam param) {
        return ((ContactDao)dao).list(param);
    }

    @Override
    public boolean read(Integer id) {
        return ((ContactDao)dao).read(id);
    }
}
