package com.cxq.designpattern.adapter.loginadapter.v1;


import com.cxq.designpattern.adapter.loginadapter.v1.service.SiginForThirdService;

/**
 * @author cnxqin
 * @desc 简单适配器
 * @date 2019/03/26 23:22
 */
public class SiginForThirdServiceTest {
    public static void main(String[] args) {
        SiginForThirdService service = new SiginForThirdService();
        service.login("chenxq","123456");
        service.loginForQQ("12345678");
        service.loginForWechat("123456789");
    }
}
