package com.cxq.java.designpattern.delegate;

/**
 * @author cnxqin
 * @desc 员工接口（使用策略模式下的员工接口）
 * @date 2019/03/24 23:08
 */
public interface EmployeeStrategy extends Employee {

    /**
     * 员工工作行为
     * @param task 任务
     */
    void work(String task);

    /**
     * 员工工作行为（策略模式）
     * @param task
     */
    void strategyWork(String task);

}
