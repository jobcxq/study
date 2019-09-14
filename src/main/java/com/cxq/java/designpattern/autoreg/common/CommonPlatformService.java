package com.cxq.java.designpattern.autoreg.common;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 15:11
 */
public abstract class CommonPlatformService {

    public Object getPlatformConfig(Object request){
        System.out.println("获取请求配置信息：请求地址、用户码及密码等");
        return new Object();
    }

    public String request(String xml){
        System.out.println("请求平台，获取响应数据");
        return "平台返回报文";
    }

    public Object saveLog(Object reponse){
        System.out.println("保存交互报文");
        return new Object();
    }

}
