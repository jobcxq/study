package com.cxq.javaSE.designpattern.decorator.battercake.v2;

/**
 * @author cnxqin
 * @desc 煎饼基础实现类
 * @date 2019/03/27 22:19
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
