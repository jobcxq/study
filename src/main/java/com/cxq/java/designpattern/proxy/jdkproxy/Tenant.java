package com.cxq.java.designpattern.proxy.jdkproxy;

/**
 * @author cnxqin
 * @desc 租户，被代理类，必须要实现接口
 * @date 2019/03/21 22:51
 */
public class Tenant implements Customer{

    private String name;

    public Tenant(String name) {
        this.name = name;
    }

    @Override
    public void tenantHouse() {
        System.out.println("[" + this.name + "]提出租房需求：大阳台、独卫。");
    }
}
