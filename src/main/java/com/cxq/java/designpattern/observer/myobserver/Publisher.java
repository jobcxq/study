package com.cxq.java.designpattern.observer.myobserver;

/**
 * @author cnxqin
 * @desc 消息发布者
 * @date 2019/03/27 23:33
 */
public class Publisher extends PublisherCenter{

    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void publish(Object object){
        this.notifyObservers(object);
    }
}
