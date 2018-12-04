package com.cxq.proxy.cglib;

import com.cxq.proxy.Constant;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxy implements MethodInterceptor {

    private static DynamicProxy instance = new DynamicProxy();

    private DynamicProxy(){

    }

    public static DynamicProxy getInstance(){
        return instance;
    }

    public <T> T getProxy(Class<T> clazz){
        return (T)Enhancer.create(clazz,this);
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Constant.before();
        Object result = methodProxy.invokeSuper(object,args);
        Constant.after();
        return result;
    }
}
