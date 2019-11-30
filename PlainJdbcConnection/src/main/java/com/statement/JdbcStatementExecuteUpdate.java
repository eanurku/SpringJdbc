package com.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcStatementExecuteUpdate {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        Statement stmt = conn.createStatement();

        int update = stmt.executeUpdate("insert into Account set accno=111,amount=45.4");

        System.out.println("update count:"+update);

    }
}
