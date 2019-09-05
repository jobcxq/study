package com.cxq.designpattern.adapter.loginadapter.v1.service;

import com.cxq.designpattern.adapter.loginadapter.Member;
import com.cxq.designpattern.adapter.loginadapter.ResultMsg;

/**
 * @author cnxqin
 * @desc 已有的功能类
 * @date 2019/03/26 23:23
 */
public class SiginService {
    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg register(String username,String password){
        return  new ResultMsg(200,"注册成功",new Member());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return new ResultMsg(200,"登录成功", new Member());
    }
}
