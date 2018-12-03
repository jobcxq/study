package com.cxq.proxy.statics;

import com.cxq.proxy.UserService;
import com.cxq.proxy.UserServiceImpl;

/**
 * 测试静态代理
 */
public class TestStaticProxy {

    public static void main(String[] args){

        UserService userService = new UserServiceProxy(new UserServiceImpl());
        userService.updateUser("12345","chenxiaoq");

    }

}
