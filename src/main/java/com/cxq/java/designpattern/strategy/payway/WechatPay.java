package com.cxq.java.designpattern.strategy.payway;

/**
 * @author cnxqin
 * @desc 微信支付
 * @date 2019/03/24 23:44
 */
public class WechatPay extends Payment{
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String account) {
        return 400;
    }
}
