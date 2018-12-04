package com.cxq.proxy.statics;

import com.cxq.proxy.Constant;
import com.cxq.proxy.UserService;
import com.cxq.proxy.UserServiceImpl;

/**
 * 静态代理，每一个被代理的类，都需要又一个与之对应的代理类
 */
public class UserServiceProxy implements UserService {

    UserServiceImpl impl;   //被代理的对象

    public UserServiceProxy(UserServiceImpl impl) {
        this.impl = impl;
    }

    @Override
    public void updateUser(String account, String userName) {
        Constant.before();
        this.impl.updateUser(account,userName);
        Constant.after();
    }

}
