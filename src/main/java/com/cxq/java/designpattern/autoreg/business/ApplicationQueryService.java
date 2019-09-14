package com.cxq.java.designpattern.autoreg.business;

import com.cxq.java.designpattern.autoreg.vo.RequestBase;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 15:23
 */
public interface ApplicationQueryService {

    Object request(RequestBase request);

}
