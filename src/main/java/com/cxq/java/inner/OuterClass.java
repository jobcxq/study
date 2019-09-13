package com.cxq.java.inner;

/**
 * @author cnxqin
 * @desc 外部类
 * @date 2019/09/13 10:45
 */
public class OuterClass {

    private final static String OUTER_IP = "192.168.0.1";

    private String addr;


    //内部类
    class InnerClass {
        private String INNER_IP = "192.168.0.1:02";   //非静态内部类不能定义静态属性
        private String addr;
    }

    //静态内部类-静态嵌套类
    static class StaticNestedClass {
        public static String STATIC_NESTED_IP = "192.168.0.1:03";
        private String addr;
    }

    public static void main(String[] args){
        //局部内部类
        class MethodInnerClass{
            String temp = OUTER_IP;    // OUTER_IP 必须为 final
            private String METHOD_INNER_IP = "192.168.0.1:04";

            public void sayHello(String str){
                System.out.println(str);
            }
        }

        //匿名内部类
        Thread thread = new Thread(new Runnable() {
            private String ANONYMOUS_IP = "192.168.0.1:05"; //不能修饰为static
            @Override
            public void run() {
                System.out.println(OUTER_IP);
                System.out.println(StaticNestedClass.STATIC_NESTED_IP);
            }
        });
    }

}
