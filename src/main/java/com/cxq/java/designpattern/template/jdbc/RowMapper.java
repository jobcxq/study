package com.cxq.java.designpattern.template.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author cnxqin
 * @desc ORM映射定制化的接口
 * @date 2019/03/25 20:47
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws SQLException;

}
