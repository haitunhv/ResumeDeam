package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Company;
import com.haitunhv.xr.bean.Experience;
import com.haitunhv.xr.dao.ExperienceDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:09
 */
public class ExperienceDaoImpl extends BaseDaoImpl<Experience> implements ExperienceDao {

    private static String QueryListSql;
    private static String getSql;
    private static RowMapper<Experience> rowMapper;
    static {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        sb.append("t1.id, t1.created_time, t1.job, t1.intro, t1.begin_day, t1.end_day, ");
        sb.append("t2.id, t2.created_time, t2.name, t2.logo, t2.website, t2.intro ");
        sb.append("FROM experience t1 JOIN company t2 ON t1.company_id = t2.id ");
        QueryListSql = sb.toString();
        getSql = sb.toString() + " WHERE t1.id = ?";

        rowMapper = (resultSet,i)->{
            Experience experience = new Experience();
            experience.setId(resultSet.getInt("t1.id"));
            experience.setCreatedTime(resultSet.getDate("t1.created_time"));
            experience.setIntro(resultSet.getString("t1.intro"));
            experience.setJob(resultSet.getString("t1.job"));
            experience.setBeginDay(resultSet.getDate("t1.begin_day"));
            experience.setEndDay(resultSet.getDate("t1.end_day"));

            Company company = new Company();
            experience.setCompany(company);
            company.setId(resultSet.getInt("t2.id"));
            company.setCreatedTime(resultSet.getDate("t2.created_time"));
            company.setIntro(resultSet.getString("t2.intro"));
            company.setLogo(resultSet.getString("t2.logo"));
            company.setWebsite(resultSet.getString("t2.website"));
            company.setName(resultSet.getString("t2.name"));
            return experience;
        };
    }
    @Override
    public boolean save(Experience bean) {
        Integer id = bean.getId();
        List<Object> ags = new ArrayList<>();
        ags.add(bean.getIntro());
        ags.add(bean.getJob());
        ags.add(bean.getBeginDay());
        ags.add(bean.getEndDay());
        ags.add(bean.getCompany().getId());
        String sql = "";
        if (id == null || id <= 0){
            sql = "INSERT INTO experience(intro,job,begin_day,end_day,company_id) VALUES(?,?,?,?,?)";
        }else {
            sql = "UPDATE experience SET intro=?,job = ?,begin_day=?,end_day=?,company_id=? WHERE id = ?";
            ags.add(id);
        }
        return Dbs.getTpl().update(sql,ags.toArray()) >0;
    }


    @Override
    public Experience get(Integer id) {
        String sql = getSql ;
        return Dbs.getTpl().queryForObject(sql, rowMapper,id);
    }

    @Override
    public List<Experience> list() {
        String sql = QueryListSql;
        return Dbs.getTpl().query(sql,rowMapper);
    }
}
