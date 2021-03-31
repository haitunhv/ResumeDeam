package com.haitunhv.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: haitunhv
 * @Date: 2021/3/31 21:15
 */
public class LogProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Object proxyObject = Proxy.newProxyInstance(
                //类加载器
                getClass().getClassLoader(),
                //代理需要实现的接口（目标类接口）
                bean.getClass().getInterfaces(),
                //附加代码（代理类的实现）
                new LogInvocationHandler(bean));
        return proxyObject;
    }

    private static class LogInvocationHandler implements InvocationHandler{
        private final Object target;
        public LogInvocationHandler(Object target){
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //proxy  代理对象
            //method  目标方法
            //args  目标方法参数
            System.out.println("1");
            Object result = method.invoke(target,args);
            return result;
        }
    }

}
