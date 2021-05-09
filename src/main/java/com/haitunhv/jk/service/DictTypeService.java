package com.haitunhv.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haitunhv.jk.pojo.po.DictType;
import com.haitunhv.jk.query.DictTypeQuery;

import java.util.List;


/**
 * @Author: haitunhv
 * @Date: 2021/5/8 22:40
 */
public interface DictTypeService extends IService<DictType> {
    List<DictType> list(DictTypeQuery query);
}
