package com.cxq.designPattern.proxy.cglibproxy;

/**
 * @author cnxqin
 * @desc cglib动态代理
 * @date 2019/03/22 21:35
 */
public class DynamicProxyTest {

    public static void main(String[] args){

        Tenant tenant = (Tenant)new Agency().getProxyInstance(new Tenant("陈小钦"));
        tenant.tenantHouse();
    }

}
