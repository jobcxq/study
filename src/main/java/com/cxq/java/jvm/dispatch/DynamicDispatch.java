package com.cxq.java.jvm.dispatch;

/**
 * @author 8000654471
 * @desc 动态分派 - 重写
 * @date 2019/9/6 8:47
 */
public class DynamicDispatch {

    public static void main(String[] args){
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello(); //Hello Man
        woman.sayHello(); //Hello Woman
        man = new Woman();
        man.sayHello();
    }

    static abstract class Human{
        protected abstract void sayHello();
    }

    static class Man extends Human{

        @Override
        public void sayHello() {
            System.out.println("Hello Man");
        }
    }

    static class Woman extends Human{

        @Override
        public void sayHello() {
            System.out.println("Hello Woman");
        }
    }

}
