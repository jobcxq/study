package com.cxq.designPattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式
 */
public class PrototypeTest {

    public static void main(String[] args){

        List<Course> courseList = new ArrayList<>();
        Course c1 = new Course("1","语文");
        Course c2 = new Course("2","数学");
        courseList.add(c1);
        courseList.add(c2);

        Teacher teacher = new Teacher("湖北大学",10,courseList);
        teacher.setName("游松发");
        teacher.setAge(50);
        teacher.setSex("M");

        try {
            Teacher clone = (Teacher) teacher.clone();
            System.out.println(teacher.toString());
            System.out.println(clone.toString());
            System.out.println(clone == teacher);
            System.out.println(clone.getCourseList() == teacher.getCourseList());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
