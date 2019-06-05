package com.cxq.javaSE.baseGrammar;

/**
 * @author cnxqin
 * @desc Integer 同 String 也是不可变类，其默认在-128~127存在缓存。
 * @date 2019/06/05 20:08
 */
public class TestInteger {

    public static void main(String[] args){

        Integer a = -128;
        Integer b = -128;
        System.out.println(a == b);
        Integer c = 127;
        Integer d = 127;
        System.out.println(c == d);
        Integer e = 100 + 27;
        Integer f = c + d;
        Integer g = 254;
        System.out.println(f == g);
        System.out.println(f.equals(g));

        System.out.println(new Integer(10) == new Integer(10));

    }

}
