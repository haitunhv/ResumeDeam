package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Education;
import com.haitunhv.xr.dao.EducationDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gss
 * @Date: 2021/2/23 22:03
 */
public class EducationDaoImpl extends BaseDaoImpl<Education> implements EducationDao {

    /**
     * 插入或更新
     * @param education
     * @return
     */
    @Override
    public boolean save(Education education){
        Integer id = education.getId();
        List<Object> ags = new ArrayList<>();
        ags.add(education.getName());
        ags.add(education.getType());
        ags.add(education.getIntro());
        ags.add(education.getBeginDay());
        ags.add(education.getEndDay());
        String sql = "";
        if (id == null || id < 0){
            sql = "INSERT INTO education(name,type,intro,begin_day,end_day) VALUES(?,?,?,?,?)";
        }else {
            sql = "UPDATE education SET name=?,type = ?,intro=?,begin_day=?,end_day=? WHERE id = ?";
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
    public Education get(Integer id){
        String sql = "SELECT id,created_time,name,type,intro,begin_day,end_day FROM education WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Education.class),id);
    }

    /**
     * 获取多个对象
     * @return
     */
    @Override
    public List<Education> list(){
        String sql = "SELECT id,created_time,name,type,intro,begin_day,end_day FROM education";
        return Dbs.getTpl().query(sql,new BeanPropertyRowMapper<>(Education.class));
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    protected String table() {
        return "education";
    }
}
