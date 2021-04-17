package com.haitunhv.controller;

import com.domain.Cat;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: haitunhv
 * @Date: 2021/4/16 23:28
 */
@RestController
@EnableConfigurationProperties(Cat.class)
public class TestController {
    public String test(){
        return "test!!!";
    }
}
