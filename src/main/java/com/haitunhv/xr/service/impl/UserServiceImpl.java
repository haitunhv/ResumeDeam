package com.haitunhv.xr.service.impl;

import com.haitunhv.xr.bean.User;
import com.haitunhv.xr.dao.UserDao;
import com.haitunhv.xr.service.UserService;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:16
 */
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Override
    public User get(User user) {
        return ((UserDao) dao).get(user);
    }
}
