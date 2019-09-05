package com.cxq.javaSE.designpattern.adapter.loginadapter.v2.adapter;

import com.cxq.javaSE.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @author cnxqin
 * @desc
 * @date 2019/03/26 23:27
 */
public interface RegistAdapter {

    boolean support(Object adapter);

    ResultMsg regist(String id, Object adapter);
}
