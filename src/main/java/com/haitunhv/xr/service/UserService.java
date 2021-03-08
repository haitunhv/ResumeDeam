package com.haitunhv.xr.service;

import com.haitunhv.xr.bean.User;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:16
 */
public interface UserService extends BaseService<User> {
    User get(User user);
}
