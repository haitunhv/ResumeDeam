package com.haitunhv.xr.dao;

import com.haitunhv.xr.bean.User;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:09
 */
public interface UserDao extends BaseDao<User> {
    User get(User user);
}
