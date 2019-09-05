package com.cxq.javaSE.designpattern.proxy.staticproxy;

/**
 * @author cnxqin
 * @desc 静态代理
 * @date 2019/03/21 22:57
 */
public class StaticProxyTest {

    public static void main(String[] args){

        new Agent(new Tenant()).findHouse();

    }

}
