package com.cxq.javaSE.designpattern.strategy.payway;

/**
 * @author cnxqin
 * @desc 银联支付
 * @date 2019/03/24 23:43
 */
public class UnionPay extends Payment{
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String account) {
        return 100;
   