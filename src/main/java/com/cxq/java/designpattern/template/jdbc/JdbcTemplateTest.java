package com.cxq.javaSE.designpattern.template.jdbc;

/**
 * @author cnxqin
 * @desc 模板模式测试类
 * @date 2019/03/25 20:52
 */
public class JdbcTemplateTest {

    public static void main(String[] args){

        MemberDao dao = new MemberDao(null);
        dao.selectAll();

    }

}
