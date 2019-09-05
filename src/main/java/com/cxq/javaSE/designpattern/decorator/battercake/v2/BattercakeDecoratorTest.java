package com.cxq.designpattern.decorator.battercake.v2;

/**
 * @author cnxqin
 * @desc 装饰器模式测试类
 * @date 2019/03/27 22:27
 */
public class BattercakeDecoratorTest {

    public static void main(String[] args){

        Battercake battercake = new BaseBattercake();
        //加鸡蛋
        battercake = new EggDecorator(battercake);
        //加香肠
        battercake = new SausageDecorator(battercake);

        System.out.println(battercake.getMsg() + " ,总价格：" + battercake.getPrice());

    }

}
