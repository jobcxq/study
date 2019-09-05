package com.cxq.java.designpattern.observer.guava;

import com.cxq.java.designpattern.observer.Message;
import com.google.common.eventbus.Subscribe;

/**
 * @author cnxqin
 * @desc guava提供的消息发布订阅工具，需要加入注解
 * @date 2019/03/27 23:20
 */
public class GuavaSubscriber {

    private String name;

    public GuavaSubscriber(String name) {
        this.name = name;
    }

    @Subscribe
    public void subscribe(Message message){
        System.out.println("订阅者[" + name + "]收到消息如下：" + message.getMessage() + "[" + message.getName() + "]");
    }

}
