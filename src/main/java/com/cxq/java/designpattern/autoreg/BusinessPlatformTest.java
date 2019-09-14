package com.cxq.java.designpattern.autoreg;

import com.cxq.java.designpattern.autoreg.restful.BusinessPlatformRestful;
import com.cxq.java.designpattern.autoreg.restful.impl.BusinessPlatformRestfulImpl;
import com.cxq.java.designpattern.autoreg.vo.ApplicationConfirmRequest;
import com.cxq.java.designpattern.autoreg.vo.ApplicationQueryRequest;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/14 15:50
 */
public class BusinessPlatformTest {

    public static void main(String[] args){

        BusinessPlatformRestful businessPlatformRestful = new BusinessPlatformRestfulImpl();

        System.out.println("投保查询开始。。。");
        businessPlatformRestful.applicationQuery(new ApplicationQueryRequest());

        System.out.println("\n投保确认开始。。。");
        businessPlatformRestful.applicationconfirm(new ApplicationConfirmRequest());


    }

}
