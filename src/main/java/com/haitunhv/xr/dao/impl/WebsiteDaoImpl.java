package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Website;
import com.haitunhv.xr.dao.WebsiteDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gss
 * @Date: 2021/2/21 23:40
 */
public class WebsiteDaoImpl extends BaseDaoImpl<Website> implements WebsiteDao {

    /**
     * 插入或更新
     * @param website
     * @return
     */
    @Override
    public boolean save(Website website){
        Integer id = website.getId();
        List<Object> ags = new ArrayList<>();
        ags.add(website.getFooter());
        String sql = "";
        if (id == null || id < 0){
            sql = "INSERT INTO website(footer) VALUES(?)";
        }else {
            sql = "UPDATE website SET footer=? WHERE id = ?";
            ags.add(id);
        }
        return Dbs.getTpl().update(sql,ags.toArray()) >0;
    }

    /**
     * 获取单个对象
     * @param id
     * @return
     */
    @Override
    public Website get(Integer id){
        return null;
    }

    /**
     * 获取多个对象
     * @return
     */
    @Override
    public List<Website> list(){
        String sql = "SELECT id,created_time,footer FROM website";
        return Dbs.getTpl().query(sql,new BeanPropertyRowMapper<>(Website.class));
    }

    /**
     * 统计
     * @return
     */
    @Override
    public int count(){
        return 0;
    }
}
