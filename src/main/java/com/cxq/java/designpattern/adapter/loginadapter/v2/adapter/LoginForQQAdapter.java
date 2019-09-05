package com.cxq.javaSE.designpattern.adapter.loginadapter.v2.adapter;

import com.cxq.javaSE.designpattern.adapter.loginadapter.Member;
import com.cxq.javaSE.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @author cnxqin
 * @desc
 * @date 2019/03/26 23:26
 */
public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return new ResultMsg(200,"登录成功",new Member());
    }
}
