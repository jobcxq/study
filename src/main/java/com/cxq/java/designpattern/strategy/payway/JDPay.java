package com.cxq.java.designpattern.strategy.payway;

/**
 * @author cnxqin
 * @desc JD支付
 * @date 2019/03/24 23:43
 */
public class JDPay extends Payment {
    @Override
    public String getName() {
        return "金东钱包";
    }

    @Override
    protected double queryBalance(String account) {
        return 10;
    }
}
