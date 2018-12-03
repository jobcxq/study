package com.cxq.proxy;

/**
 * 不使用代理的实现方式
 */
public class UserServiceImpl implements UserService {

    @Override
    public void updateUser(String account, String userName) {

//        before();
        System.out.println("do update user account=" + account + ", userName=" + userName);
//        after();
    }

    public static void before() {
        System.out.println("before update user!");
    }


    public static void after() {
        System.out.println("after update user!");
    }

}
