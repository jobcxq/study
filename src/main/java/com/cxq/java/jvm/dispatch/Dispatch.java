package com.cxq.java.jvm.dispatch;

/**
 * @author 8000654471
 * @desc 静态分派（多分派）和动态分派（单分派）
 * @date 2019/9/6 9:16
 */
public class Dispatch {

    public static void main(String[] args){

        Father father = new Father();
        Father son = new Son();

        father.choice(new WeChat());
        son.choice(new QQ());

    }

    static class QQ{}
    static class WeChat{}

    public static class Father{
        public void choice(QQ qq){
            System.out.println("Father choice qq");
        }

        public void choice(WeChat weChat){
            System.out.println("Father choice weChat");
        }

    }

    public static class Son extends Father{
        public void choice(QQ qq){
            System.out.println("Son choice qq");
        }

        public void choice(WeChat weChat){
            System.out.println("Son choice weChat");
        }

    }


}
