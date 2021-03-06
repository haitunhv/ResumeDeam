package com.haitunhv.xr.dao.impl;

import com.haitunhv.xr.dao.BaseDao;
import com.haitunhv.xr.until.Dbs;
import com.haitunhv.xr.until.Strings;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/2/28 17:42
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    protected String table(){
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class beanClass = (Class) type.getActualTypeArguments()[0];
        return Strings.underlineCase(beanClass.getSimpleName());
    }

    @Override
    public boolean remove(Integer id){
        String sql = "DELETE FROM "+table()+" WHERE id = ?";
        return Dbs.getTpl().update(sql,id) > 0;
    }

    @Override
    public boolean removeAll(List<Integer> ids){
        List<Object> args = new ArrayList<>();
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM ");
        sql.append(table());
        sql.append(" WHERE id in (");
        for (Integer id : ids) {
            args.add(id);
            sql.append("?, ");
        }
        sql.replace(sql.length()-2,sql.length(),")");

        return Dbs.getTpl().update(sql.toString(),args.toArray()) >0;
    }


    @Override
    public int count() {
        return 0;
    }
}
