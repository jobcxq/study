package com.cxq.java.designpattern.decorator.battercake.v1;

/**
 * @author cnxqin
 * @desc 煎饼 + 1个鸡蛋 + 1根香肠
 * @date 2019/03/27 22:13
 */
public class BattercakeWithEggAndSausage extends BattercakeWithEgg {

    @Override
    protected String getMsg() {
        return super.getMsg() + " + 1根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }

}
