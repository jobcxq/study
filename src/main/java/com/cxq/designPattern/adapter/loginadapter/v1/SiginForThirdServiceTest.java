package com.cxq.designPattern.adapter.loginadapter.v1;

import com.cxq.designPattern.adapter.loginadapter.v1.service.SinginForThirdService;

/**
 * @author cnxqin
 * @desc
 * @date 2019/03/26 23:22
 */
public class SiginForThirdServiceTest {
    public static void main(String[] args) {
        SinginForThirdService service = new SinginForThirdService();
        service.login("chenxq","123456");
        service.loginForQQ("sdfasdfasf");
        service.loginForWechat("sdfasfsa");
    }
}
