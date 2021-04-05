package com.haitunhv.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: haitunhv
 * @Date: 2021/3/29 22:29
 */
@Component
public class Person {
    @Autowired
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                '}';
    }
}
