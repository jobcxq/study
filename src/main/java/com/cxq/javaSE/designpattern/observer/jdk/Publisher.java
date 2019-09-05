package com.cxq.javaSE.designpattern.observer.jdk;

import com.cxq.javaSE.designpattern.observer.Message;

import java.util.Observable;

/**
 * @author cnxqin
 * @desc 发布者，即被观察者
 * @date 2019/03/27 22:59
 */
public class Publisher extends Observable {

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

    public void publish(Message message){
        this.setChanged();              //设置发生改变标志位
//        this.notifyObservers();         //不带参数发布消息
        this.notifyObservers(message); // 带参数发布消息