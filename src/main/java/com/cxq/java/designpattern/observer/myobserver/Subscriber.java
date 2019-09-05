package com.cxq.java.designpattern.observer.myobserver;

import com.cxq.java.designpattern.observer.Message;

/**
 * @author cnxqin
 * @desc 接收者
 * @date 2019/03/27 23:40
 */
public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void receive(Object object) {
        Message message = (Message) object;
        System.out.println("订阅者[" + name + "]收到消息如下：" + message.getMessage() + "[" + message.getName() + "]");
    }
}
