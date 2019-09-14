package com.cxq.java.designpattern.autoreg.common;

import com.cxq.java.designpattern.autoreg.vo.RequestBase;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 15:09
 */
public abstract class AbstractPlatformService extends CommonPlatformService {

    public Object request(RequestBase request) {

        //请求数据校验
        Object checkResut = chechRequestDate(request);

        //某些接口需要的特殊逻辑
        //生成缓存 key 字段 ，只是投保查询需要
        Object cacahKey = generateCacahKey(request);

        //获取请求地址、用户名及密码
        Object platformConfig = getPlatformConfig(request);

        //请求报文序列化组装
        String xml = getRequestXml(request);

        //请求平台
        String responseData = request(xml);

        //解析响应报文
        Object reponse = parseResponse(responseData);

        //保存交互报文
        Object saveResult = saveLog(reponse);

        System.out.println("请求结束返回");
        return reponse;
    }

    //需要投保查询重写的方法
    protected Object generateCacahKey(RequestBase request) {
        return null;
    }

    protected abstract Object parseResponse(String responseData);

    protected abstract String getRequestXml(Object request);

    protected Object chechRequestDate(RequestBase request){
        //1 校验基本信息
        System.out.println("请求基本信息校验");
        //2 业务信息校验
        
        return doRequestDateCheck(request);
    }

    /**
     * 业务信息校验
     * @param request
     * @return
     */
    protected abstract Object doRequestDateCheck(RequestBase request);

}
