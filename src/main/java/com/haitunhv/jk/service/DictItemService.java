package com.haitunhv.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haitunhv.jk.pojo.po.DictItem;
import com.haitunhv.jk.query.DictItemQuery;
import com.haitunhv.jk.query.DictTypeQuery;


/**
 * @Author: haitunhv
 * @Date: 2021/5/8 22:40
 */
public interface DictItemService extends IService<DictItem> {
    void list(DictItemQuery query);
}
