package com.cxq.java.object.clone;

import java.io.*;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/05 22:01
 */
public class User implements Cloneable{

    String name;

    public User() { }

    public User(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User("cxq");
        //必须要实现 Cloneable接口
        //浅克隆，不克隆引用类型，引用类型引用的是同一个对象
        User clone = (User) user.clone();
        System.out.println(user);
        System.out.println(clone);
        //可使用序列化实现深克隆
    }

    //深克隆
    public User deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this);
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        return (User) ois.readObject();
    }

}
