package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.bean.Contact;
import com.haitunhv.xr.bean.vo.ContactListParam;
import com.haitunhv.xr.bean.vo.ContactListResult;
import com.haitunhv.xr.dao.ContactDao;
import com.haitunhv.xr.until.Dbs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            sql = "INSERT INTO contact(name,email,comment,subject,already_read) VALUES(?,?,?,?,?)";
        }else {
            sql = "UPDATE contact SET name=?,email = ?,comment=?,subject=?,already_read=? WHERE id = ?";
            ags.add(id);
        }
        return Dbs.getTpl().update(sql,ags.toArray()) >0;
    }

    @Override
    public Contact get(Integer id) {
        String sql = "SELECT id,created_time,name,email,comment,subject,already_read FROM contact WHERE id = ?";
        return Dbs.getTpl().queryForObject(sql, new BeanPropertyRowMapper<>(Contact.class),id);
    }

    @Override
    public List<Contact> list() {
        String sql = "SELECT id,created_time,name,email,comment ,subject ,already_read FROM contact";
        return Dbs.getTpl().query(sql,new BeanPropertyRowMapper<>(Contact.class));
    }

    @Override
    public ContactListResult list(ContactListParam param){
        ContactListResult result = new ContactListResult();
        StringBuffer sql = new StringBuffer();
        StringBuffer condition = new StringBuffer();
        sql.append("SELECT id,created_time,name,email,comment ,subject ,already_read FROM contact WHERE 1=1 ");

        List<Object> ags = new ArrayList<>();

        String keyWord = param.getKeyWord();
        if (keyWord != null && keyWord.length() >0){
            result.setKeyWord(keyWord);
            condition.append("AND (name LIKE ? OR email LIKE ? OR comment LIKE ? OR subject LIKE ?)");
            keyWord = "%"+keyWord+"%";
            ags.add(keyWord);
            ags.add(keyWord);
            ags.add(keyWord);
            ags.add(keyWord);
        }

        if (param.getBeginDay() != null){
            condition.append("AND created_time >= ?");
            ags.add(param.getBeginDay());
            result.setBeginDay(param.getBeginDay());
        }

        if (param.getEndDay() != null){
            condition.append("AND created_time <= ?");
            ags.add(param.getEndDay());
            result.setEndDay(param.getEndDay());
        }

        Integer read = param.getAlreadyRead();
        if (read != null && read < ContactListParam.READ_ALL){
            condition.append("AND already_read = ?");
            ags.add(param.getAlreadyRead());
            result.setAlreadyRead(read);
        }
        Integer pageSize = param.getPageSize();
        if (pageSize == null){
            pageSize = 5;
        }
        String countSql = "SELECT COUNT(*) FROM contact WHERE 1=1 " + condition.toString();
        Integer count = Dbs.getTpl().queryForObject(countSql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt(1);
            }
        },ags.toArray());
        Integer totalPages = (count + pageSize -1)/pageSize;
        result.setTotalCount(totalPages);
        result.setTotalPages(count);


        sql.append("LIMIT ?,?");
        Integer pageNo = param.getPageNo();
        if (pageNo == null){
            pageNo = 1;
        }else if (totalPages > count){
            pageNo = 1;
        }

        ags.add((pageNo - 1) * pageSize);
        ags.add(pageSize);
        result.setPageNo(pageNo);
        result.setPageSize(pageSize);
        List<Contact> contactsList = Dbs.getTpl().query(sql.toString(), new BeanPropertyRowMapper<>(Contact.class),ags.toArray());

        result.setContacts(contactsList);
        return result;
    }

    @Override
    public boolean read(Integer id) {
        String sql = "UPDATE contact SET already_read = 1 WHERE id = ?";
        return Dbs.getTpl().update(sql,id)>0;
    }
}
