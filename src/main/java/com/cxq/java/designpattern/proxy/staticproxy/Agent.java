package com.cxq.javaSE.designpattern.proxy.staticproxy;

/**
 * @author cnxqin
 * @desc 代理人/中介
 * @date 2019/03/21 22:54
 */
public class Agent {

    private Customer customer;

    public Agent(Customer customer) {
        this.customer = customer;
    }

    public void findHouse(){
        before();
        customer.tenantHouse();
        after();
    }

    private void before(){
        System.out.println("发布房源信息");
    }

    private void after(){
        System.out.println("租房，签订合同。");
    }

}
