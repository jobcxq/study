package com.cxq.java.mysql;

import java.sql.*;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/05 22:26
 */
public class SelectTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://CentOS_01:3306/study";
        String username = "root";
        String password = "1234";

        Connection connection = DriverManager.getConnection(url,username,password);

        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

}
