package com.cxq.proxy;

public class UserManageServiceImpl implements UserService{

    @Override
    public void updateUser(String account, String userName) {
        System.out.println("manager update user account=" + account + ", userName=" + userName);
    }
}
