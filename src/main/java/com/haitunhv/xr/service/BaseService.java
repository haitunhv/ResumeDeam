package com.haitunhv.xr.service;

import com.haitunhv.xr.bean.Education;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/2/28 17:58
 */
public interface BaseService<T> {
    /**
     * 删除
     * @param id
     * @return
     */
    boolean remove(Integer id);
    /**
     * 删除
     * @param ids
     * @return
     */
    boolean removeAll(List<Integer> ids);

    /**
     * 插入或更新
     * @param base
     * @return
     */
    boolean save(T base);

    /**
     * 获取单个对象
     * @param id
     * @return
     */
    T get(Integer id);

    /**
     * 获取多个对象
     * @return
     */
    List<T> list();

    /**
     * 统计
     * @return
     */
    int count();
}
