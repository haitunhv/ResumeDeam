package com.haitunhv;

import com.haitunhv.service.PersonService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: haitunhv
 * @Date: 2021/3/31 20:31
 */
public class PersonTest {
    @Test
    public void test(){
        //创建容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //目标对象
        PersonService target = ctx.getBean("personService",PersonService.class);

        //代理对象
        ClassLoader loader = getClass().getClassLoader();

        PersonService personService = (PersonService) Proxy.newProxyInstance(
                //类加载器
                loader,
                //代理需要实现的接口（目标类接口）
                target.getClass().getInterfaces(),
                //附加代码（代理类的实现）
                (Object proxy, Method method, Object[] args)-> {
                    //proxy  代理对象
                    //method  目标方法
                    //args  目标方法参数
                    System.out.println("1");
                    Object result = method.invoke(target,args);
                        return result;
                });

        personService.save("123",456);

        ctx.close();
    }
    @Test
    public void test1(){
        //创建容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //目标对象
        PersonService target = ctx.getBean("personService",PersonService.class);


        target.save("123",456);

        ctx.close();
    }
}
