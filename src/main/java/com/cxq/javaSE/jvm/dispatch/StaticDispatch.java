package com.cxq.javaSE.jvm.dispatch;

/**
 * @author 8000654471
 * @desc 静态分派
 * @date 2019/9/5 9:27
 */
public class StaticDispatch {

    public void sayHello(Human human){
        System.out.println("hello human");
    }

    public void sayHello(Man man){
        System.out.println("hello man");
    }

    public void sayHello(Woman woman){
        System.out.println("hello woman");
    }

    public static void main(String[] args){
        StaticDispatch dispatch = new StaticDispatch();
        Human man = new Man();      //Human 为变量的静态类型，Man 为实际类型
        Human woman = new Woman();
        //静态分派，虚拟机重载时通过参数的静态类型来作为判定依据（编译器在编译阶段就可以确定）
        dispatch.sayHello(man);     //hello human
        dispatch.sayHello(woman);   //hello human

    }

}

class Human{

}

class Man extends Human{

}

class Woman extends Human{

}
