package com.cxq.designpattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cnxqin
 * @desc JDBC操作模板类
 * @date 2019/03/25 20:17
 */
public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //模板方法
    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values){
        try {
            //1、获取连接
            Connection conn = this.getConnection();

            //2、创建语句集
            PreparedStatement pstm = this.createPrepareStatement(conn, sql);

            //3、执行语句
            ResultSet rs = this.executeQuery(pstm, values);

            //4、处理结果
            List<?> result = this.pareseResultSet(rs, rowMapper);

            //5、关闭结果集
            this.closeResultSet(rs);

            //6、关闭语句集
            this.closeStatement(pstm);

            //7、关闭连接
            this.closeConnection(conn);

            //8、返回查询结果
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    protected void closeConnection(Connection conn) throws SQLException {
        //应该使用数据库连接池
        if(conn != null){
            conn.close();
        }
    }

    protected void closeStatement(PreparedStatement pstm) throws SQLException {
        if(pstm != null){
            pstm.close();
        }
    }

    protected void closeResultSet(ResultSet rs) throws SQLException {
        if(rs != null){
            rs.close();
        }
    }

    protected List<?> pareseResultSet(ResultSet rs, RowMapper rowMapper) throws SQLException {
        if(rs == null || rowMapper == null){
            return null;
        }
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()){
            result.add(rowMapper.mapRow(rs,rowNum ++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws SQLException {
        if(pstm != null){
            for (int i = 0; i < values.length; i++) {
                pstm.setObject(i,values[i]);
            }
            return pstm.executeQuery();
        }
        return null;
    }

    protected PreparedStatement createPrepareStatement(Connection conn, String sql) throws SQLException {
        if(conn != null){
            return conn.prepareStatement(sql);
        }
        return null;
    }

    protected Connection getConnection() throws SQLException {
        if(this.dataSource != null){
            return this.dataSource.getConnection();
        }
        return null;
    }


}
