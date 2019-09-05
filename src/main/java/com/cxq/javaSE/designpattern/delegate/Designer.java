package com.cxq.javaSE.designpattern.delegate;

/**
 * @author cnxqin
 * @desc 设计师
 * @date 2019/03/24 23:10
 */
public class Designer implements Employee{

    @Override
    public void work(String task) {
        System.out.println("设计师设计工作：" + task);
   