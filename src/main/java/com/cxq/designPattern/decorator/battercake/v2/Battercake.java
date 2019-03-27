package com.cxq.designPattern.decorator.battercake.v2;

/**
 * @author cnxqin
 * @desc 煎饼抽象类
 * @date 2019/03/27 22:18
 */
public abstract class Battercake {

    /**
     * 煎饼
     * @return
     */
    protected abstract String getMsg();

    /**
     * 煎饼价格
     * @return
     */
    protected abstract int getPrice();

}
