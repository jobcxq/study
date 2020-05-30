package com.cxq.java.designpattern.singleton;

import com.alibaba.fastjson.JSON;
import com.cxq.java.designpattern.singleton.hungry.HungrySingleton;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 8000654471
 * @desc 破坏单例
 * @date 2020/5/22 16:13
 */
public class AttackSingleton {

    /**
     *反射破坏，需要在构造函数中增加判断，当单例不为null时，抛出异常
     */
    @Test
    public void reflex(){
        HungrySingleton singleton = HungrySingleton.getInstance();
        System.out.println(singleton);
        try {
            Constructor<HungrySingleton> constructor = HungrySingleton.class.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            singleton = constructor.newInstance(null);
            System.out.println(singleton);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * json 序列化，也需要在构造函数中增加判断，当单例不为null时，抛出异常
     */
    @Test
    public void toJson(){
        HungrySingleton singleton = HungrySingleton.getInstance();
        System.out.println(singleton);

//        Gson gson = new GsonBuilder().create();
//        String json = gson.toJson(singleton);
//
//        singleton = gson.fromJson(json,HungrySingleton.class);
        String json = JSON.toJSONString(singleton);

        singleton = JSON.parseObject(json,HungrySingleton.class);
        System.out.println(singleton);
    }

    /**
     * 序列化和反序列化，对于实现了 Serializable 接口的实体类
     * 修改下返序列化策略，实体类增加如下方法
     * private Object readResolve(){
     *     return getInstance();
     * }
     */
    @Test
    public void serialize(){
        HungrySingleton singleton = HungrySingleton.getInstance();
        System.out.println(singleton);
        try {
            OutputStream os = new FileOutputStream("singleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(singleton);

            //反序列化
            InputStream is = new FileInputStream("singleton.obj");
            ObjectInputStream ois = new ObjectInputStream(is);
            singleton = (HungrySingleton) ois.readObject();
            System.out.println(singleton);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 克隆破坏单例，对于实现了 Cloneable 接口的实体类
     * 重写 clone 方法，返回单例对象或抛出异常
     */
    @Test
    public void byClone(){
        HungrySingleton singleton = HungrySingleton.getInstance();
        System.out.println(singleton);

        try {
            System.out.println(singleton.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }




}
