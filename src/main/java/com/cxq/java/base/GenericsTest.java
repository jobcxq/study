package com.cxq.java.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxqin
 * @desc 泛型
 * @date 2019/09/18 19:10
 */
public class GenericsTest<T> {

    public static void main(String[] args){
        List<Dog> dogs = new ArrayList<>();
        countLeg2(dogs);

    }

    public static int countLeg1(List<Animal> animals){
        int count = 0;
        for (Animal animal : animals){
            count += animal.countLeg();
        }
        return count;
    }

    public static int countLeg2(List<? extends Animal> animals){
        int count = 0;
        for (Animal animal : animals){
            count += animal.countLeg();
        }
        return count;
    }
}

class Animal{

    public int countLeg(){
       return 0;
    }
}

class Dog extends Animal{

    public int countLeg(){
        return 2;
    }

}