package com;

import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainDemo {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate template = context.getBean("studentJdbcTemplate",StudentJdbcTemplate.class);

//        Connection conn = template.getDatasourceobj().getConnection();
//        System.out.println(conn.getTransactionIsolation());
//        System.out.println(conn.getCatalog());
//        DatabaseMetaData meta = template.getDatasourceobj().getConnection().getMetaData();
//        System.out.println(meta.getTableTypes().getStatement());





    }

}
