package com.cxq.designPattern.delegate;

/**
 * @author cnxqin
 * @desc 老板分配任务，只与Leader存在关联
 * @date 2019/03/24 23:23
 */
public class Boss {

    private Leader leader;

    public Boss(Leader leader) {
        this.leader = leader;
    }

    public void work(String task){
        leader.work(task);
        System.out.println("=====使用策略模式=====");
        leader.strategyWork(task);
    }


}
