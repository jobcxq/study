package com.cxq.proxy.jdk;

import com.cxq.proxy.UserService;
import com.cxq.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        UserServiceImpl.after();
        Object result = method.invoke(object,args);
        UserServiceImpl.after();

        return result;
    }


}
