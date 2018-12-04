package com.cxq.proxy;

/**
 * 不使用代理的实现方式
 */
public class UserServiceImpl implements UserService {

    @Override
    public void updateUser(String account, String userName) {

//        Constant.before();
        System.out.println("do update user account=" + account + ", userName=" + userName);
//        Constant.after();
    }

}
