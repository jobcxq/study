package com.cxq.java.inner;

/**
 * @author cnxqin
 * @desc 内部类的使用
 * @date 2019/09/13 11:20
 */
public class InnerClassTest {

    public static void main(String[] args){
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

    }
}
