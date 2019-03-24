package com.cxq.designPattern.strategy;

/**
 * @author cnxqin
 * @desc 策略模式（支付方式选择）
 * @date 2019/03/24 23:38
 */
public class PayStrategyTest {

    public static void main(String[] args){

        new Order("11111",50).pay();

    }

}
