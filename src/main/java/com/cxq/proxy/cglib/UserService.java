package com.cxq.proxy.cglib;

public class UserService {

    public void updateUser(String account, String userName) {
        System.out.println("do update user account=" + account + ", userName=" + userName);
    }

}
