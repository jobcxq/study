package com.cxq.java.designpattern.adapter.loginadapter.v2;

import com.cxq.java.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @author cnxqin
 * @desc 需要进行扩展的新功能类
 * @date 2019/03/26 23:24
 */
public interface PassportForThird {

    /**
     * QQ登录
     * @param id
     * @return
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     * @return
     */
    ResultMsg loginForWechat(String id);

    /**
     * 记住登录状态后自动登录
     * @param token
     * @return
     */
    ResultMsg loginForToken(String token);

    /**
     * 手机号登录
     * @param telphone
     * @param code
     * @return
     */
    ResultMsg loginForTelphone(String telphone, String code);

    /**
     * 注册后自动登录
     * @param username
     * @param passport
     * @return
     */
    ResultMsg loginForRegist(String username, String passport);

}
