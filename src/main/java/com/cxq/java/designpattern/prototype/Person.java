package com.cxq.java.designpattern.prototype;

import java.io.Serializable;

//若父类不实现 Serializable 接口，则反序列化时，父类属性会丢失。
//可以通过父类实现该接口，或者在子类中手动负责父类的序列化
public class Person implements Serializable {

    private String name;
    private String sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
