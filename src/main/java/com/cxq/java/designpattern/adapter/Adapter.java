package com.cxq.javaSE.designpattern.adapter;

/**
 * @author cnxqin
 * @desc 适配器格式
 * @date 2019/03/26 23:13
 */
public class Adapter implements Target{
    private Adaptee adaptee;
    //...
}

/**
 * 已存在的，需要适配的类，即被适配的类
 */
class Adaptee{

}

/**
 * 供用户（客户端）调用的类
 */
interface Target{

}
