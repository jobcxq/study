package com.cxq.designPattern.decorator.battercake.v1;

/**
 * @author cnxqin
 * @desc 煎饼类
 * @date 2019/03/27 22:11
 */
public class Battercake {

    protected String getMsg(){
        return "煎饼";
    }

    /**
     * 煎饼价格
     * @return
     */
    public int getPrice(){
        return 5;
    }

}
