package com.cxq.designPattern.delegate;

/**
 * @author cnxqin
 * @desc 开发人员
 * @date 2019/03/24 23:11
 */
public class Developer implements Employee {

    @Override
    public void work(String task) {
        System.out.println("开发人员工作 ：" + task);
    }
}
