package com.cxq.java.designpattern.autoreg.business.impl;

import com.cxq.java.designpattern.autoreg.business.ApplicationConfirmService;
import com.cxq.java.designpattern.autoreg.common.AbstractPlatformService;
import com.cxq.java.designpattern.autoreg.vo.RequestBase;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 15:34
 */
public class ApplicationConfirmServiceImpl extends AbstractPlatformService
        implements ApplicationConfirmService {

    @Override
    protected Object parseResponse(String responseData) {
        System.out.println("【投保确认】 解析响应数据");
        return null;
    }

    @Override
    protected String getRequestXml(Object request) {
        System.out.println("【投保确认】 请求数据组装");
        return null;
    }

    @Override
    protected Object doRequestDateCheck(RequestBase request) {
        System.out.println("【投保确认】 业务数据校验");
        return null;
    }
}
