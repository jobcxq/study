package com.cxq.designPattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author cnxqin
 * @desc 中介机构，代理类，只能代理接口。
 * @date 2019/03/21 22:54
 */
public class Agency implements MethodInterceptor {

    private Object customer;

    /**
     * 对应代理对象的无参构造器
     * @param customer
     * @return
     */
//    public Object getProxyInstance(Object customer) {
//        //相当于Proxy，代理的工具类
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(customer.getClass());
//        enhancer.setCallback(this);
//        return enhancer.create();
//    }

    /**
     * 对应代理对象的无参构造器
     * @param customer
     * @param <T>
     * @return
     */
    public <T>T getProxyInstance(T customer) {
//        return (T)Enhancer.create((Class) customer,this);
        //相当于Proxy，代理的工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(customer.getClass());
        enhancer.setCallback(this);
        return (T)enhancer.create();
    }

    /**
     * 带参数的代理
     * @param customer 代理对象
     * @param argumentTypes 对应的构造器参数类型
     * @param arguments 对应的构造器参数值
     * @param <T> <泛型方法>
     * @return 返回代理对象类型
     */
    public <T>T getProxyInstance(T customer,Class[] argumentTypes, Object[] arguments) {
        //相当于Proxy，代理的工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(customer.getClass());
        enhancer.setCallback(this);
        return (T)enhancer.create(argumentTypes,arguments);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o,objects);
        after();
        return result;
    }

    private void before(){
        System.out.println("发布房源信息");
    }

    private void after(){
        System.out.println("租房，签订合同。");
    }

}
