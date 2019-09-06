package com.cxq.java.jvm.dispatch;

/**
 * @author 8000654471
 * @desc 静态分派 - 重载
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
        //虚拟机编译器通过参数的静态类型来作为判定依据，在编译阶段根据参数的静态类型来决定使用的重载版本
        //静态分派：发生在编译阶段，依赖静态类型来定位方法执行版本的分派，典型应用：方法重载
        dispatch.sayHello(man);     //hello human
        dispatch.sayHello(woman);

    }

    static class Human{

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

}

