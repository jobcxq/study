package com.cxq.java.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestArrayList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");

        for(int i = 0; i < list.size(); i ++){
            list.remove(2);
            System.out.println(list.get(i));

        }

//        for(String str : list){
//            System.out.println(str);
//            list.remove(2);
//        }

        Set set = new HashSet();
        set.add("1111");
        set.add("332222");
        set.add("22333");

        List list1 = new ArrayList(set);
        System.out.println(list1);
        System.out.println(set.toArray()[0]);

        set.stream().filter((str) -> ((String)str).startsWith("22")).findFirst().ifPresent((str) -> {System.out.println(str);});

    }

}
