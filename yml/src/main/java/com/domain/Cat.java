package com.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * Author: haitunhv
 * @Date: 2021/4/17 17:01
 */
@ConfigurationProperties("cat")
@ConstructorBinding
@Data
public class Cat {
    private Integer id;
    private String name;

    public Cat(Integer id ,String name){
        this.id = id;
        this.name = name;
    }
}
