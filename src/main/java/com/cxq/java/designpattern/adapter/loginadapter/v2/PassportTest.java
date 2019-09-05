package com.cxq.java.designpattern.adapter.loginadapter.v2;

import com.cxq.java.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @author cnxqin
 * @desc 适配器模式，结合了策略模式及工厂模式
 * @date 2019/03/26 23:25
 */
public class PassportTest {

    public static void main(String[] args){

        PassportForThird passportForThird = new PassportForThirdAdapter();
        ResultMsg msg =  passportForThird.loginForQQ("12345678");
        System.out.println(msg.toString());

    }

}
