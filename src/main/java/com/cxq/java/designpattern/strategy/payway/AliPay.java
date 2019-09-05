package com.cxq.javaSE.designpattern.strategy.payway;

/**
 * @author cnxqin
 * @desc 支付宝
 * @date 2019/03/24 23:42
 */
public class AliPay extends  Payment{
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String account) {
        return 5000;
    }
}
