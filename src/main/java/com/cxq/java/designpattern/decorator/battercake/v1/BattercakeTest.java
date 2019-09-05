package com.cxq.java.designpattern.decorator.battercake.v1;

/**
 * @author cnxqin
 * @desc 不使用装饰器模式测试类
 * @date 2019/03/27 22:15
 */
public class BattercakeTest {
    public static void main(String[] args){

        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() + ", 总价格：" + battercake.getPrice());

        //加一个鸡蛋
        Battercake battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg() + ", 总价格：" + battercakeWithEgg.getPrice());

        //再加一根香肠
        Battercake battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
        System.out.println(battercakeWithEggAndSausage.getMsg() + ", 总价格：" + battercakeWithEggAndSausage.getPrice());


    }
}
