package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Experience;
import com.haitunhv.xr.dao.ExperienceDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:09
 */
public class ExperienceDaoImpl extends BaseDaoImpl<Experience> implements ExperienceDao {

    @Override
    public boolean save(Experience bean) {
        Integer id = bean.getId();
        List<Object> ags = new ArrayList<>();

        String sql = "";
        if (id == null || id <= 0){
            sql = "INSERT INTO award(name,image,intro) VALUES(?,?,?)";
        }else {
            sql = "UPDATE award SET name=?,image = ?,intro=? WHERE id = ?";
            ags.add(id);
        }
        return Dbs.getTpl().update(sql,ags.toArray()) >0;
    }

    @Override
    public Experience get(Integer id) {
        String sql = "SELECT id,created_time,name,image,intro FROM award WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Experience.class),id);
    }

    @Override
    public List<Experience> list() {
        String sql = "SELECT id,created_time,name,image,intro FROM award";
        return Dbs.getTpl().query(sql,new BeanPropertyRowMapper<>(Experience.class));
    }
}
