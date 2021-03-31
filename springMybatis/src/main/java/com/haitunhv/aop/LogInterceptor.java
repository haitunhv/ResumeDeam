package com.haitunhv.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: gss
 * @Date: 2021/3/31 22:25
 */
public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("1---------------------");

        Object result = methodInvocation.proceed();

        System.out.println("2---------------------");
        return result;
    }
}
