package com.cxq.javaSE.designpattern.adapter.loginadapter.v2.adapter;

import com.cxq.javaSE.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @author cnxqin
 * @desc
 * @date 2019/03/26 23:27
 */
public class LoginForTokenAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
