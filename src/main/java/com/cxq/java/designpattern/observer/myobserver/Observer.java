package com.cxq.java.designpattern.observer.myobserver;

/**
 * @author cnxqin
 * @desc 消息订阅接口
 * @date 2019/03/27 23:32
 */
public interface Observer {

    /**
     * 接收消息
     * @param object
     */
    void receive(Object object);

}
