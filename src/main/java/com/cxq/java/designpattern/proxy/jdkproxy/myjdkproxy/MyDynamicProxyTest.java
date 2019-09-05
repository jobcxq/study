package com.cxq.java.designpattern.proxy.jdkproxy.myjdkproxy;

import com.cxq.java.designpattern.proxy.jdkproxy.Customer;
import com.cxq.java.designpattern.proxy.jdkproxy.Tenant;

/**
 * @author cnxqin
 * @desc
 * @date 2019/03/23 00:12
 */
public class MyDynamicProxyTest {

    public static void main(String[] args){
        try{
            Customer customer = (Customer)new Agency().getProxyInstance(new Tenant("陈小钦"));
            customer.tenantHouse();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
