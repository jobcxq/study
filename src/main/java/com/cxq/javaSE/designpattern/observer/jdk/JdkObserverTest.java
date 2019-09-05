package com.cxq.designpattern.observer.jdk;

import com.cxq.designpattern.observer.Message;

/**
 * @author cnxqin
 * @desc jdk提供观察者模式测试
 * @date 2019/03/27 23:11
 */
public class JdkObserverTest {

    public static void main(String[] args){

        Publisher publisher = new Publisher("中国气象局");
        Subscriber subscriber1 = new Subscriber("小明");
        Subscriber subscriber2 = new Subscriber("小华");

        //先订阅消息
        publisher.addObserver(subscriber1);
        publisher.addObserver(subscriber2);

        //发布消息
        publisher.publish(new Message(publisher.getName(),"预计明天中到大雨，请市民做好防雨措施！"));

    }

}
