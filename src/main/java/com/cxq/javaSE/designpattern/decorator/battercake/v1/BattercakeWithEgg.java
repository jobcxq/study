package com.cxq.designpattern.decorator.battercake.v1;

/**
 * @author cnxqin
 * @desc 煎饼加鸡蛋
 * @date 2019/03/27 22:12
 */
public class BattercakeWithEgg extends Battercake {

    @Override
    protected String getMsg() {
        return super.getMsg() + " + 1个鸡蛋";
    }

    /**
     * 煎饼 + 1个鸡蛋价格
     * @return
     */
    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
