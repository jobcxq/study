package com.cxq.javaSE.designpattern.strategy.payway;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cnxqin
 * @desc 支付策略
 * @date 2019/03/24 23:45
 */
public class PayStrategy {

    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JDPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> payWayMap = new HashMap<>();

    static {
        payWayMap.put(DEFAULT_PAY,new AliPay());
        payWayMap.put(ALI_PAY,new AliPay());
        payWayMap.put(WECHAT_PAY,new WechatPay());
        payWayMap.put(UNION_PAY,new UnionPay());
        payWayMap.put(JD_PAY,new JDPay());
    }

    //单例模式-懒汉
    private PayStrategy(){}


    /**
     * 获取支付方式
     * @param payway
     * @return
     */
    public static Payment getPayWay(String payway){
        if(payway == null || !payWayMap.containsKey(payway)){
            return payWayMap.get("DEFAULT_PAY");
        }
        return payWayMap.get(payway);
    }