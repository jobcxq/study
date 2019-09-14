package com.cxq.java.designpattern.autoreg.restful;

import com.cxq.java.designpattern.autoreg.vo.ApplicationConfirmRequest;
import com.cxq.java.designpattern.autoreg.vo.ApplicationQueryRequest;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 15:08
 */
public interface BusinessPlatformRestful {

    Object applicationQuery(ApplicationQueryRequest request);

    Object applicationconfirm(ApplicationConfirmRequest request);

}
