package com.haitunhv.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haitunhv.jk.pojo.po.DictType;
import com.haitunhv.jk.pojo.vo.PageVo;
import com.haitunhv.jk.pojo.vo.list.DictTypeVo;
import com.haitunhv.jk.pojo.vo.req.page.DictTypePageReqVo;

public interface DictTypeService extends IService<DictType> {
    PageVo<DictTypeVo> list(DictTypePageReqVo query);
}