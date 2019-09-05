package com.cxq.javaSE.designpattern.decorator.battercake.v2;

/**
 * @author cnxqin
 * @desc 煎饼的装饰器（抽象类）
 * @date 2019/03/27 22:22
 */
public abstract class BattercakeDecorator extends Battercake {

    //静态代理，委派
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }

    protected abstract void doSomething();

}
