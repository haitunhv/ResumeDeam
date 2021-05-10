package com.haitunhv.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haitunhv.jk.mapper.DictItemMapper;
import com.haitunhv.jk.pojo.po.DictItem;
import com.haitunhv.jk.query.DictItemQuery;
import com.haitunhv.jk.query.DictTypeQuery;
import com.haitunhv.jk.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @Author: haitunhv
 * @Date: 2021/5/8 22:41
 */
@Service
@Transactional
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements DictItemService {
    @Autowired
    private DictItemMapper mapper;

    @Override
    public void list(DictItemQuery query) {
        LambdaQueryWrapper<DictItem> wrapper = new LambdaQueryWrapper<>();
        String keyword = query.getKeyWord();

        if (!StringUtils.isEmpty(keyword)){
            wrapper.like(DictItem::getName,keyword).or()
                    .like(DictItem::getValue,keyword);
        }

        Page<DictItem> page = new Page<>(query.getPage(),query.getSize());

        mapper.selectPage(page,wrapper);
        query.setCount(page.getCurrent());
        query.setPages(page.getPages());
        query.setData(page.getRecords());
    }

}
