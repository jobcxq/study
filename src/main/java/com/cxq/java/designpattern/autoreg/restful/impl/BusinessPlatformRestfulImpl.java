package com.cxq.java.designpattern.autoreg.restful.impl;

import com.cxq.java.designpattern.autoreg.business.ApplicationConfirmService;
import com.cxq.java.designpattern.autoreg.business.ApplicationQueryService;
import com.cxq.java.designpattern.autoreg.business.impl.ApplicationConfirmServiceImpl;
import com.cxq.java.designpattern.autoreg.business.impl.ApplicationQueryServiceImpl;
import com.cxq.java.designpattern.autoreg.restful.BusinessPlatformRestful;
import com.cxq.java.designpattern.autoreg.vo.ApplicationConfirmRequest;
import com.cxq.java.designpattern.autoreg.vo.ApplicationQueryRequest;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 15:07
 */
public class BusinessPlatformRestfulImpl implements BusinessPlatformRestful {

    ApplicationQueryService applicationQueryService = new ApplicationQueryServiceImpl();

    ApplicationConfirmService applicationConfirmService = new ApplicationConfirmServiceImpl();

    @Override
    public Object applicationQuery(ApplicationQueryRequest request) {
        return applicationQueryService.request(request);
    }

    @Override
    public Object applicationconfirm(ApplicationConfirmRequest request) {
        return applicationConfirmService.request(request);
    }
}
