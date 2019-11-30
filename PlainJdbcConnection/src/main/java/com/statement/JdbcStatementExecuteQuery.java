package com.statement;

import java.sql.*;

public class JdbcStatementExecuteQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from Account");

        while(rs.next()){
            System.out.println(rs.getInt("accno")+" "+rs.getDouble("amount"));

        }


    }



}
