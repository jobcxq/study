package com.cxq.javaSE.designpattern.strategy;

import com.cxq.javaSE.designpattern.strategy.payway.PayStrategy;
import com.cxq.javaSE.designpattern.strategy.payway.Payment;

/**
 * @author cnxqin
 * @desc 订单
 * @date 2019/03/24 23:52
 */
public class Order {

    private String account;
    private double amount;

    public Order(String account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    //完美地解决了switch的过程，不需要在代码逻辑中写switch（if...else if）了
    public String pay(){
        return pay(PayStrategy.DEFAULT_PAY);
    }

    /**
     * 支付
     * @param payKey
     * @return
     */
    public String pay(String payKey){
        Payment payment = PayStrategy.getPayWay(payKey);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本次交易金额为：" + amount + "，开始扣款...");
        return payment.pay(account,amount);
    }
}
