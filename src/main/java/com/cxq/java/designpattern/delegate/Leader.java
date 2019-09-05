package com.cxq.javaSE.designpattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cnxqin
 * @desc 团队领导者，委派者
 * @date 2019/03/24 23:12
 */
public class Leader implements EmployeeStrategy{

    /**
     * 策略模式使用
     */
    private Map<String,Employee> team = new HashMap<>();

    public Leader() {
        team.put("design",new Designer());
        team.put("develop",new Developer());
    }

    /**
     * 简单方式的委派
     * @param task 任务
     */
    @Override
    public void work(String task) {
        System.out.println("团队领导者开始分配任务..." );
        if(task == null){
            return;
        }
        if(task.equals("design")){
            new Designer().work(task);
        }else if(task.equals("develop")){
            new Developer().work(task);
        }
    }

    @Override
    public void strategyWork(String task) {
        if(task == null || !team.containsKey(task)){
            return;
        }
        team.get(task).work(task);
    }
}
