package com.haitunhv.service;

import org.springframework.stereotype.Service;

/**
 * @Author: haitunhv
 * @Date: 2021/3/31 20:33
 */
@Service
public interface PersonService {

    boolean save(String name,Integer level);
}
