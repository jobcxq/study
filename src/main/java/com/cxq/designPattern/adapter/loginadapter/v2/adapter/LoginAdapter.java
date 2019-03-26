package com.cxq.designPattern.adapter.loginadapter.v2.adapter;

import com.cxq.designPattern.adapter.loginadapter.ResultMsg;

/**
 * @author cnxqin
 * @desc
 * @date 2019/03/26 23:25
 * 在适配器里面，这个接口是可有可无
 */
public interface  LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);

}
