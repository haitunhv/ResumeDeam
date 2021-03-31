package com.haitunhv.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: haitunhv
 * @Date: 2021/3/31 21:15
 */
public class LogProcessor2 implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!beanName.endsWith("Service")) return bean;

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(getClass().getClassLoader());
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(new LogMethodInterceptor(bean));
        return enhancer.create();
    }
    private static class LogMethodInterceptor implements MethodInterceptor{
        private final Object target;
        public LogMethodInterceptor(Object target){
            this.target = target;
        }
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("1--------------");

            Object result = method.invoke(target,objects);
            System.out.println("2--------------");

            return result;
        }
    }

}
