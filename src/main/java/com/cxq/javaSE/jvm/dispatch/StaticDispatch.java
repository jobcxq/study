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
        Human man = new Man();
        Human woman = new Woman();
        //静态分派，
        dispatch.sayHello(man);     //hello human
        dispatch.sayHello(woman);   //hello human

        Man man1 = new Man();
        Woman woman1 = new Woman();
        dispatch.sayHello(man1);     //hello human
        dispatch.sayHello(woman1);   //hello human

    }

}

class Human{

}

class Man extends Human{

}

class Woman extends Human{

}
