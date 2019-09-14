package com.cxq.java.designpattern.autoreg.business.impl;

import com.cxq.java.designpattern.autoreg.business.ApplicationQueryService;
import com.cxq.java.designpattern.autoreg.common.AbstractPlatformService;
import com.cxq.java.designpattern.autoreg.vo.RequestBase;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 15:24
 */
public class ApplicationQueryServiceImpl extends AbstractPlatformService
        implements ApplicationQueryService {

    @Override
    protected Object parseResponse(String responseData) {
        //解析返回数据
        System.out.println("【投保查询】 解析响应数据");
        return null;
    }

    @Override
    protected String getRequestXml(Object request) {
        //组装请求数据
        System.out.println("【投保查询】 请求数据组装");
        return null;
    }

    @Override
    protected Object doRequestDateCheck(RequestBase request) {
        //业务数据校验
        System.out.println("【投保查询】 业务数据校验");
        return null;
    }

    @Override
    protected Object generateCacahKey(RequestBase request) {
        System.out.println("【投保查询】 生成缓存 key");
        return new Object();
    }
}
