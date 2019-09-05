package com.cxq.java.designpattern.proxy.jdkproxy.myjdkproxy;

import java.lang.reflect.Method;

/**
 * @author cnxqin
 * @desc
 * @date 2019/03/22 21:56
 */
public interface MyInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
