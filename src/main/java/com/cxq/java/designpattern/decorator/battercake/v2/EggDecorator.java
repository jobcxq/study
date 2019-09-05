package com.cxq.java.designpattern.decorator.battercake.v2;

/**
 * @author cnxqin
 * @desc 煎饼加鸡蛋
 * @date 2019/03/27 22:24
 */
public class EggDecorator extends BattercakeDecorator {
    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + " + 1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }

    @Override
    protected void doSomething() {
        System.out.println("鸡蛋自定义方法");
    }
}
