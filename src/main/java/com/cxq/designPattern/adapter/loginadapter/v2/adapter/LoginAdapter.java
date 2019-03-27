package com.cxq.designPattern.adapter.loginadapter.v2.adapter;

import com.cxq.designPattern.adapter.loginadapter.ResultMsg;

/**
 * @author cnxqin
 * @desc 通用代码的抽象，在适配器模式中，不需要一定存在
 * @date 2019/03/26 23:25
 */
public interface  LoginAdapter {

    /**
     * 适配器的类型检查
     * @param adapter
     * @return
     */
    boolean support(Object adapter);

    /**
     *
     * @param id
     * @param adapter
     * @return
     */
    ResultMsg login(String id, Object adapter);

}
