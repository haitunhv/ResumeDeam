package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Company;
import com.haitunhv.xr.dao.CompanyDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:09
 */
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao {

    @Override
    public boolean save(Company bean) {
        Integer id = bean.getId();
        List<Object> ags = new ArrayList<>();
        ags.add(bean.getName());
        ags.add(bean.getWebsite());
        ags.add(bean.getIntro());
        ags.add(bean.getLogo());

        String sql = "";
        if (id == null || id <= 0){
            sql = "INSERT INTO company(name,website,intro,logo) VALUES(?,?,?,?)";
        }else {
            sql = "UPDATE company SET name=?,website = ?,intro=?,logo=? WHERE id = ?";
            ags.add(id);
        }
        return Dbs.getTpl().update(sql,ags.toArray()) >0;
    }

    @Override
    public Company get(Integer id) {
        String sql = "SELECT id,created_time,name,website,intro,logo FROM company WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Company.class),id);
    }

    @Override
    public List<Company> list() {
        String sql = "SELECT id,created_time,name,website,intro,logo FROM company";
        return Dbs.getTpl().query(sql,new BeanPropertyRowMapper<>(Company.class));
    }
}
