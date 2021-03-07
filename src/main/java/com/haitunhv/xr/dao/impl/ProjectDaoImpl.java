package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Company;
import com.haitunhv.xr.bean.Project;
import com.haitunhv.xr.bean.Project;
import com.haitunhv.xr.dao.ProjectDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/1 22:09
 */
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {

    private static String QueryListSql;
    private static String getSql;
    private static RowMapper<Project> rowMapper;
    static {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT ");
        sb.append("t1.id, t1.created_time, t1.name, t1.intro, t1.website, t1.image, t1.begin_day, t1.end_day, ");
        sb.append("t2.id, t2.created_time, t2.name, t2.logo, t2.website, t2.intro ");
        sb.append("FROM project t1 JOIN company t2 ON t1.company_id = t2.id ");
        QueryListSql = sb.toString();
        getSql = sb.toString() + " WHERE t1.id = ?";

        rowMapper = (resultSet,i)->{
            Project project = new Project();
            project.setId(resultSet.getInt("t1.id"));
            project.setCreatedTime(resultSet.getDate("t1.created_time"));
            project.setIntro(resultSet.getString("t1.intro"));
            project.setName(resultSet.getString("t1.name"));
            project.setBeginDay(resultSet.getDate("t1.begin_day"));
            project.setEndDay(resultSet.getDate("t1.end_day"));
            project.setWebsite(resultSet.getString("t1.website"));
            project.setImage(resultSet.getString("t1.image"));

            Company company = new Company();
            project.setCompany(company);
            company.setId(resultSet.getInt("t2.id"));
            company.setCreatedTime(resultSet.getDate("t2.created_time"));
            company.setIntro(resultSet.getString("t2.intro"));
            company.setLogo(resultSet.getString("t2.logo"));
            company.setWebsite(resultSet.getString("t2.website"));
            company.setName(resultSet.getString("t2.name"));
            return project;
        };
    }
    @Override
    public boolean save(Project bean) {
        Integer id = bean.getId();
        List<Object> ags = new ArrayList<>();
        ags.add(bean.getIntro());
        ags.add(bean.getName());
        ags.add(bean.getBeginDay());
        ags.add(bean.getEndDay());
        ags.add(bean.getImage());
        ags.add(bean.getWebsite());
        ags.add(bean.getCompany().getId());
        String sql = "";
        if (id == null || id <= 0){
            sql = "INSERT INTO project(intro,name,begin_day,end_day,image,website,company_id) VALUES(?,?,?,?,?,?,?)";
        }else {
            sql = "UPDATE project SET intro=?,name = ?,begin_day=?,end_day=?,image=?,website=?,company_id=? WHERE id = ?";
            ags.add(id);
        }
        return Dbs.getTpl().update(sql,ags.toArray()) >0;
    }


    @Override
    public Project get(Integer id) {
        String sql = getSql ;
        return Dbs.getTpl().queryForObject(sql, rowMapper,id);
    }

    @Override
    public List<Project> list() {
        String sql = QueryListSql;
        return Dbs.getTpl().query(sql,rowMapper);
    }
}
