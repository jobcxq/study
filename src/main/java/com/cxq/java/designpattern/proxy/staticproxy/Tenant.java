package com.cxq.java.designpattern.proxy.staticproxy;

/**
 * @author cnxqin
 * @desc 租户
 * @date 2019/03/21 22:51
 */
public class Tenant implements Customer{

    @Override
    public void tenantHouse() {
        System.out.println("提出租房需求：大阳台、独卫。");
    }
}
