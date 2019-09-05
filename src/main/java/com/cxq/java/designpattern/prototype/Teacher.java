package com.cxq.java.designpattern.prototype;

import java.io.*;
import java.util.List;

public class Teacher extends Person implements Cloneable, Serializable {

    private String school;
    private int techYear;   //教龄

    private List<Course> courseList;

    public Teacher() {
    }

    public Teacher(String school, int techYear, List<Course> courseList) {
        this.school = school;
        this.techYear = techYear;
        this.courseList = courseList;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getTechYear() {
        return techYear;
    }

    public void setTechYear(int techYear) {
        this.techYear = techYear;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    //深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            os.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream is = new ObjectInputStream(bis);

            return (Teacher) is.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " Teacher{" +
                "school='" + school + '\'' +
                ", techYear=" + techYear +
                ", courseList=" + courseList +
                '}';
    }
}
