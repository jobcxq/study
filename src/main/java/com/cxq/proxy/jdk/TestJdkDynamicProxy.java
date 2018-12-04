package com.cxq.proxy.jdk;

import com.cxq.proxy.UserManageServiceImpl;
import com.cxq.proxy.UserService;
import com.cxq.proxy.UserServiceImpl;

public class TestJdkDynamicProxy {

    public static void main(String[] args){

        UserService userService = new DynamicProxy(new UserServiceImpl()).getProxy();
        userService.updateUser("1234","chenxiaoqin");

        UserService userManagerService = new DynamicProxy(new UserManageServiceImpl()).getProxy();
        userManagerService.updateUser("12345","chenxq");

    }

}
