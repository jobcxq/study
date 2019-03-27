package com.cxq.designPattern.observer.jdk;

import com.cxq.designPattern.observer.Message;

import java.util.Observable;
import java.util.Observer;

/**
 * @author cnxqin
 * @desc 订阅者，及消息接收者
 * @date 2019/03/27 23:04
 */
public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Publisher publisher = (Publisher)o;
        Message message = (Message) arg;
        System.out.println("订阅者[" + name + "]收到消息如下：" + message.getMessage() + "[" + publisher.getName() + "]");
    }
}
