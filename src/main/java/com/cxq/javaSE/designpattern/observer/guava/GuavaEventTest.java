package com.cxq.designpattern.observer.guava;

import com.cxq.designpattern.observer.Message;
import com.google.common.eventbus.EventBus;

/**
 * @author cnxqin
 * @desc Guava 提供的消息订阅测试类
 * @date 2019/03/27 23:24
 */
public class GuavaEventTest {

    public static void main(String[] args){
        EventBus eventBus = new EventBus();
        GuavaSubscriber subscriber1 = new GuavaSubscriber("小陈");
        GuavaSubscriber subscriber2 = new GuavaSubscriber("小张");
        eventBus.register(subscriber1);
        eventBus.register(subscriber2);
        eventBus.post(new Message("中国气象局","预计明天中到大雨，请市民做好防雨措施！"));
    }

}
