package com.haitunhv.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: haitunhv
 * @Date: 2021/5/8 22:47
 */
@SpringBootApplication
@MapperScan("com.haitunhv.jk.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
