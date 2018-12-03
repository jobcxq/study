package com.cxq.proxy.jdk;

import com.cxq.proxy.UserService;
import com.cxq.proxy.UserServiceImpl;

public class TestDynamicProxy {

    public static void main(String[] args){

        DynamicProxy proxy = new DynamicProxy(new UserServiceImpl());

    }

}
