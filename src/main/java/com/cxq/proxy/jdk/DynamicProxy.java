package com.cxq.proxy.jdk;

import com.cxq.proxy.Constant;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    public <T> T getProxy(){
        /**
         * Proxy是专门完成代理的操作类，是所有动态代理类的父类。通过此类为一个或多个接口动态地生成实现类
         */
        return (T)Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Constant.before();
        Object result = method.invoke(object,args);
        Constant.after();
        return result;
    }


}
