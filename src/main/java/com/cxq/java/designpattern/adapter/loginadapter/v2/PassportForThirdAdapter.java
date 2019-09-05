package com.cxq.javaSE.designpattern.adapter.loginadapter.v2;

import com.cxq.javaSE.designpattern.adapter.loginadapter.ResultMsg;
import com.cxq.javaSE.designpattern.adapter.loginadapter.v1.service.SiginService;
import com.cxq.javaSE.designpattern.adapter.loginadapter.v2.adapter.*;

/**
 * @author cnxqin
 * @desc 适配器，结合策略模式、工厂模式、适配器模式
 * @date 2019/03/26 23:25
 */
public class PassportForThirdAdapter extends SiginService implements PassportForThird{

    @Override
    public ResultMsg loginForQQ(String id) {
//        return processLogin(id,RegistForQQAdapter.class);
        //策略模式，根据不同场景选择不同适配器
        return processLogin(id,LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        //策略模式，根据不同场景选择不同适配器
        return processLogin(id,LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token,LoginForTokenAdapter.class);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return processLogin(telphone,LoginForTelAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        super.register(username,passport);
        return super.login(username,passport);
    }

    /**
     * 简单工厂模式，来进行统一处理
     * @param key 业务数据
     * @param clazz 限制适配器，必须是实现了 LoginAdapter 接口的
     * @return
     */
    private ResultMsg processLogin(String key,Class<? extends LoginAdapter> clazz){
        try{
            //适配器不一定要实现接口
            LoginAdapter adapter = clazz.newInstance();

            //判断传过来的适配器是否能处理指定的逻辑
            if(adapter.support(adapter)){
                return adapter.login(key,adapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
