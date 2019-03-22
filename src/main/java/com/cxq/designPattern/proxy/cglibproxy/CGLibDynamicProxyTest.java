package com.cxq.designPattern.proxy.cglibproxy;

/**
 * @author cnxqin
 * @desc cglib动态代理
 * @date 2019/03/22 21:35
 */
public class CGLibDynamicProxyTest {

    public static void main(String[] args){

        Agency agency = new Agency();

        //未传递参数给代理对象。会调用被代理类的无参构造器，此时被代理对象的构造器入参不起作用
        Tenant tenant = agency.getProxyInstance(new Tenant("陈小钦"));
        tenant.tenantHouse();

        tenant = agency.getProxyInstance(new Tenant(),new Class[]{String.class},new String[]{"陈小钦"});
        tenant.tenantHouse();
    }

}
