package com.cxq.javaSE.designpattern.observer.myobserver;

import java.util.LinkedList;

/**
 * @author cnxqin
 * @desc 消息发布中心
 * @date 2019/03/27 23:34
 */
public class PublisherCenter {
    private LinkedList<Observer> subscriberList = new LinkedList<>();

    public void addObserver(Observer subscriber){
        subscriberList.add(subscriber);
    }

    public void notifyObservers(final Object object){
        subscriberList.stream().forEach((subscriber) -> subscriber.receive(object));
    }

}
