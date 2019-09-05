package com.cxq.java.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 8000654471
 * @desc
 * @date 2019/6/28 9:06
 */
public class AtomicReferenceTest {

    static AtomicReference<User> reference = new AtomicReference<>();

    public static void main(String[] args){
        User old = new User("abc",10);
        User update = new User("def",15);

        reference.set(old);
        reference.compareAndSet(old,update);

        System.out.println(reference.get());
        System.out.println(old);
        System.out.println(update);
    }

}
class User {

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
