package com.cxq.designPattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cnxqin
 * @desc 中介机构，代理类，只能代理接口。
 * @date 2019/03/21 22:54
 */
public class Agency implements InvocationHandler {

    private Object customer;

    public Object getProxyInstance(Object customer) {
        this.customer = customer;
        Class<?> clazz = customer.getClass();
        return Proxy.newProxyInstance(customer.getClass().getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object =method.invoke(customer,args);
        after();
        return object;
    }

    private void before(){
        System.out.println("发布房源信息");
    }

    private void after(){
        System.out.println("租房，签订合同。");
    }

}
