package com.haitunhv.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: haitunhv
 * @Date: 2021/4/1 21:50
 */
public class TxInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //开启事务

        Object result = null;
        try {
            result = methodInvocation.proceed();
        }catch (Exception e){
            //回滚事务
        }

        //提交事务


        return result;
    }
}
