package com.cxq.javaSE.arrays;

import java.util.ArrayList;
import java.util.List;

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

        for(String str : list){
            System.out.println(str);
            list.remove(2);
        }

    }

}
