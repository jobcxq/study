package com.cxq.java.map;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {

    public static void main(String[] args) {

        Integer a = 0x8ACE;
//        a = a >>> 8;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a >>> 8));
        a = a ^ (a >>> 8);
        System.out.println(Integer.toBinaryString(a));
        ;

        Map<String,String> map = new HashMap();
        map.put("1","chen");
        map.put("2","xiao");
        map.put("3","qin");
        System.out.println(map);

    }

}
