package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Skill;
import com.haitunhv.xr.dao.SkillDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gss
 * @Date: 2021/2/28 19:49
 */
public class SkillDaoImpl extends BaseDaoImpl<Skill> implements SkillDao {

    @Override
    public boolean save(Skill bean){
        Integer id = bean.getId();
        List<Object> ags = new ArrayList<>();
        ags.add(bean.getName());
        ags.add(bean.getLevel());
        String sql = "";
        if (id == null || id <= 0){
            sql = "INSERT INTO skill(name,level) VALUES(?,?)";
        }else {
            sql = "UPDATE skill SET name=?,level = ? WHERE id = ?";
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
    public Skill get(Integer id){
        String sql = "SELECT id,created_time,name,level FROM skill WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Skill.class),id);
    }

    /**
     * 获取多个对象
     * @return
     */
    @Override
    public List<Skill> list(){
        String sql = "SELECT id,created_time,name,level FROM skill";
        return Dbs.getTpl().query(sql,new BeanPropertyRowMapper<>(Skill.class));
    }

    @Override
    public int count() {
        return 0;
    }
}
