package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Contact;
import com.haitunhv.xr.dao.ContactDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:09
 */
public class ContactDaoImpl extends BaseDaoImpl<Contact> implements ContactDao {

    @Override
    public boolean save(Contact bean) {
        Integer id = bean.getId();
        List<Object> ags = new ArrayList<>();
        ags.add(bean.getName());
        ags.add(bean.getEmail());
        ags.add(bean.getComment());
        ags.add(bean.getSubject());
        ags.add(bean.getAlreadyRead());

        String sql = "";
        if (id == null || id <= 0){
            sql = "INSERT INTO contact(name,email,comment,subject,alredy_read) VALUES(?,?,?,?,?)";
        }else {
            sql = "UPDATE contact SET name=?,email = ?,comment=?,subject=?,alredy_read=? WHERE id = ?";
            ags.add(id);
        }
        return Dbs.getTpl().update(sql,ags.toArray()) >0;
    }

    @Override
    public Contact get(Integer id) {
        String sql = "SELECT id,created_time,name,email,comment,subject,alredy_read FROM contact WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Contact.class),id);
    }

    @Override
    public List<Contact> list() {
        String sql = "SELECT id,created_time,name,email,comment ,subject ,alredy_read FROM contact";
        return Dbs.getTpl().query(sql,new BeanPropertyRowMapper<>(Contact.class));
    }
}
