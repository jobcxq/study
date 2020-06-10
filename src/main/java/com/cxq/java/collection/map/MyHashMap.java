package com.cxq.java.collection.map;

import java.util.HashMap;
import java.util.Iterator;
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
        map.put("3","qin");
        map.put("3","qin");
        map.put("3","qin");
        map.put("3","qin");
        map.put("3","qin");
        System.out.println(map);

        Map<Key,String> keyMap = new HashMap();
        for(int i = 0; i < 100; i ++){
            String key = "cxq" + i;
            keyMap.put(new Key(key),key + i);
        }
        System.out.println(keyMap.size());

        Iterator<Key> iterator = keyMap.keySet().iterator();
        while (iterator.hasNext()){
            Key key = iterator.next();
            keyMap.remove(key);
        }

    }


}
class Key {

    private String name;

    Key(){

    }

    Key(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Key)obj).getName());
    }
}
