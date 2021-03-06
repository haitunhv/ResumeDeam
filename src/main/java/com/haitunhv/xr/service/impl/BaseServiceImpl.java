package com.haitunhv.xr.service.impl;

import com.haitunhv.xr.dao.BaseDao;
import com.haitunhv.xr.service.BaseService;
import com.haitunhv.xr.until.Strings;

import java.util.List;

/**
 * @Author: gss
 * @Date: 2021/2/28 17:59
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected BaseDao<T> dao = dao();
    protected BaseDao<T> dao(){
        String className = getClass().getName()
                .replace(".service.",".dao.")
                .replace("Service","Dao");
        try {
            return (BaseDao<T>) Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 插入或更新
     *
     * @param bean
     * @return
     */
    @Override
    public boolean save(T bean) {
        return dao().save(bean);
    }


    /**
     * 获取单个对象
     * @param id
     * @return
     */
    @Override
    public T get(Integer id){
        return dao().get(id);
    }

    /**
     * 获取多个对象
     * @return
     */
    @Override
    public List<T> list(){
        return dao().list();
    }

    @Override
    public int count() {
        return 0;
    }


    @Override
    public boolean remove(Integer id){
        return dao().remove(id);
    }

    @Override
    public boolean removeAll(List<Integer> ids){
        return dao().removeAll(ids);
    }
}
