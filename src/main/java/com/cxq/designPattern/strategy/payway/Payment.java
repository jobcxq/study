package com.cxq.designPattern.strategy.payway;

/**
 * @author cnxqin
 * @desc 支付接口
 * @date 2019/03/24 23:38
 */
public abstract class Payment {

    /**
     * 支付类型
     * @return
     */
    public abstract String getName();

    /**
     * 查询余额
     * @param account
     * @return
     */
    protected abstract double queryBalance(String account);

    /**
     * 支付
     * @param account
     * @param amount
     * @return
     */
    public String pay(String account, double amount) {
        if(queryBalance(account) < amount){
            return "支付失败,余额不足";
        }
        return "支付成功,支付金额：" + amount;
    }

}
