package com.cxq.java.designpattern.proxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * @author cnxqin
 * @desc JDK动态代理
 * @date 2019/03/21 23:06
 */
public class JdkDynamicProxyTest {

    public static void main(String[] args){
        try {
            Proxy proxy = (Proxy)new Agency().getProxyInstance(new Tenant("陈小钦"));
//            Method method = proxy.getClass().getMethod("tenantHouse",null);
//            method.invoke(proxy);
            Customer customer = (Customer) proxy;
            customer.tenantHouse();

            //保存生成的代理类对象
            //$Proxy0
            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Customer.class});
            FileOutputStream os = new FileOutputStream("D:\\IdeaProjects\\log\\$Proxy0.class");
            os.write(bytes);
            os.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
