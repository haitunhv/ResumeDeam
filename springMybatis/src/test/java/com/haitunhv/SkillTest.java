package com.haitunhv;

import com.haitunhv.domain.Dog;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: haitunhv
 * @Date: 2021/4/4 15:40
 */
public class SkillTest {
    private ApplicationContext ctx;

    @Before
    public void before(){
//        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx = new AnnotationConfigApplicationContext("com.haitunhv");
    }

    @Test
    public void test(){
        System.out.println(ctx.getBean("dog"));
        System.out.println(ctx.getBean("person"));
    }
}
