package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.User;
import com.haitunhv.xr.dao.UserDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:09
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public boolean save(User bean) {
        Integer id = bean.getId();
        List<Object> ags = new ArrayList<>();
        ags.add(bean.getPassword());
        ags.add(bean.getEmail());
        ags.add(bean.getPhoto());
        ags.add(bean.getIntro());
        ags.add(bean.getName());
        ags.add(bean.getBirthday());
        ags.add(bean.getAddress());
        ags.add(bean.getPhone());
        ags.add(bean.getJob());
        ags.add(bean.getTrait());
        ags.add(bean.getInterests());
        String sql = "";
        if (id == null || id <= 0){
            sql = "INSERT INTO user(password,email,photo,intro,name,birthday,address,phone,job,trait,interests) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        }else {
            sql = "UPDATE user SET password=?,email = ?,photo=?,intro=?,name=?,birthday=?,address=?,phone=?,job=?,trait=?,interests=? WHERE id = ?";
            ags.add(id);
        }
        return Dbs.getTpl().update(sql,ags.toArray()) >0;
    }

    @Override
    public User get(Integer id) {
        String sql = "SELECT id,created_time,password,email,photo,intro,name,birthday,address,phone,job,trait,interests FROM user WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(User.class),id);
    }

    @Override
    public List<User> list() {
        String sql = "SELECT id,created_time,password,email,photo,intro,name,birthday,address,phone,job,trait,interests FROM user";
        return Dbs.getTpl().query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User get(User user) {
        String sql = "SELECT id,created_time,password,email,photo,intro,name,birthday,address,phone,job,trait,interests FROM user WHERE email = ? AND password = ?";
        List<User> userList = Dbs.getTpl().query(sql, new BeanPropertyRowMapper<>(User.class),user.getEmail(),user.getPassword());
        return userList.isEmpty()? null:userList.get(0);
    }
}
