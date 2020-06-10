package com.cxq.java.mysql;

import java.sql.*;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/05 22:26
 */
public class SelectTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
//        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://CentOS_01:3306/arp?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url,username,password);

        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(Thread.currentThread().getName() + " " + resultSet.getString("user_name"));
        }

//        Thread.currentThread().setName("mysql");
//        connection.setAutoCommit(false);
//        String sql = "select * from user for update";
//        Statement statement = connection.createStatement();
//        statement.execute(sql);
//        connection.commit();
//
        MyRunMysql myRunMysql = new MyRunMysql();

        new Thread(myRunMysql,"mysql1").start();
        new Thread(myRunMysql,"mysql2").start();
        System.out.println(Thread.currentThread().getName() + " ok");



    }

    static class MyRunMysql implements Runnable{

        @Override
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");

//        Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://CentOS_01:3306/arp?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "1234";

            Connection connection = DriverManager.getConnection(url,username,password);

//        String sql = "select * from user";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString("user_name"));
//        }

            connection.setAutoCommit(false);
            if("mysql1".equals(Thread.currentThread().getName())){
                String sql = "select * from user for update";
                Statement statement = connection.createStatement();
                statement.execute(sql);
                System.out.println("mysql1 lock user");
                Thread.sleep(2000);
                sql = "select * from t_pub_policy_region_cfg for update";
                statement = connection.createStatement();
                statement.execute(sql);
                System.out.println("mysql1 lock t_pub_policy_region_cfg");
            }else{
                String sql = "select * from t_pub_policy_region_cfg for update";
                Statement statement = connection.createStatement();
                statement.execute(sql);
                System.out.println("mysql2 lock t_pub_policy_region_cfg");
                Thread.sleep(2000);
                sql = "select * from user for update";
                statement = connection.createStatement();
                statement.execute(sql);
                System.out.println("mysql2 lock user");
            }

            connection.commit();

            System.out.println(Thread.currentThread().getName() + " ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
