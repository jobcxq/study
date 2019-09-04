package com.cxq.javaSE.base;

import java.lang.reflect.Field;

/**
 * @author cnxqin
 * @desc Integer 同 String 也是不可变类，其默认在-128~127存在缓存。
 * @date 2019/06/05 20:08
 */
public class TestInteger {

    public static void main(String[] args){

        //Integer 类型变量的缓存范围 -128 ~ 127
        Integer a = -128;
        Integer b = -128;
        System.out.println(a == b);
        Integer c = 127;
        Integer d = 127;
        System.out.println(c == d);
        Integer e = 100 + 27;
        Integer f = c + d;
        Integer g = 254;
        System.out.println(f == g); // 254超过了缓存范围
        System.out.println(f.equals(g));

        System.out.println(new Integer(10) == new Integer(10));//重新在堆中分配

        System.out.println(Integer.valueOf(5));

        Integer x = 5, y = 6, z = 7;
        swap1(x, y); //交换后 值不变仍为：x=5, y=6
        System.out.println("x=" + x + ", y=" + y);

        swap2(x, y); //交换后 值不变仍为：x=6, y=6
        System.out.println("x=" + x + ", y=" + y);

        swap3(x, z);
        System.out.println("x=" + x + ", z=" + z);

    }

    // java 中参数的传递都是“值传递”，且 8 中包装类和 String 都是不可变对象
    public static void swap1(Integer a , Integer b){
        int tmp = a;
        a = b;
        b = tmp;
    }

    //-128 ~127 交换会存在问题
    public static void swap2(Integer a , Integer b){
        int tmp = a;
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(a, b.intValue()); // a -> Integer.valueOf(b.intValue());此处将缓冲的值也更改了
            System.out.println("tmp=" + tmp + ", Integer.valueOf(tmp) = " + Integer.valueOf(tmp));
            System.out.println(Integer.valueOf(5));
            field.set(b, tmp);      // b -> Integer.valueOf(b.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void swap3(Integer a , Integer b){
        Integer tmp = new Integer(a.intValue());//不使用缓冲，防止缓冲值被替换。
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(a, b.intValue());
            field.set(b, tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
