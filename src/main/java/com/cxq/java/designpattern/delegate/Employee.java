package com.cxq.javaSE.designpattern.delegate;

/**
 * @author cnxqin
 * @desc 员工接口
 * @date 2019/03/24 23:08
 */
public interface Employee {

    /**
     * 员工工作行为
     * @param task 任务
     */
    void work(String task);

}
