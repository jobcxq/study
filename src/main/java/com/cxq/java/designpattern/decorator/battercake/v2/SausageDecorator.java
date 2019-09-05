package com.cxq.java.designpattern.decorator.battercake.v2;

/**
 * @author cnxqin
 * @desc 煎饼加香肠
 * @date 2019/03/27 22:26
 */
public class SausageDecorator extends BattercakeDecorator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + " + 1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }

    @Override
    protected void doSomething() {
        System.out.println("香肠自定义方法");
    }
}
