package com.cxq.proxy.cglib;


public class TestCglibDynamicProxy {

    public static void main(String[] args){
        UserService userService = DynamicProxy.getInstance().getProxy(new UserService().getClass());
        userService.updateUser("1234","chenxiaoqin");
    }
}
