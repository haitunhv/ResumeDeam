package com.haitunhv.service.impl;

import com.haitunhv.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @Author: haitunhv
 * @Date: 2021/3/31 20:34
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public boolean save(String name, Integer level) {
        System.out.println(name+"_"+level);
        return false;
    }
}
