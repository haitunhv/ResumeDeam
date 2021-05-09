package com.haitunhv.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haitunhv.jk.mapper.DictTypeMapper;
import com.haitunhv.jk.pojo.po.DictType;
import com.haitunhv.jk.query.DictTypeQuery;
import com.haitunhv.jk.service.DictTypeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/5/8 22:41
 */
@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {
    @Autowired
    private DictTypeMapper mapper;

    @Override
    public List<DictType> list(DictTypeQuery query) {
        LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<>();
        String keyword = query.getKeyWord();

        if (!StringUtils.isEmpty(keyword)){
            wrapper.like(DictType::getName,keyword).or()
                    .like(DictType::getValue,keyword).or()
                    .like(DictType::getIntro,keyword);
        }


        return mapper.selectList(wrapper);
    }
}
