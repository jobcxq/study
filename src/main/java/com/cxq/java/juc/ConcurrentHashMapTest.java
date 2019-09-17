package com.cxq.java.juc;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args){

        ConcurrentHashMap hashMap = new ConcurrentHashMap(10);
        new ConcurrentHashMap();

        hashMap.put("111","222");
        hashMap.get("111");
        hashMap.get("111");

    }

}
