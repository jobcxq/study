package com.cxq.java.designpattern.delegate;

/**
 * @author cnxqin
 * @desc 委派模式
 * @date 2019/03/24 23:07
 */
public class DelegateTest {

    public static void main(String[] args){

        new Boss(new Leader()).work("design");
        System.out.println("==================\n");
        new Boss(new Leader()).work("develop");

    }

}
