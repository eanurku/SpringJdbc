package com.dbconnection;

import java.sql.*;

public class ConnectionByClassForName {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root1234");
        Statement stmt = conn.createStatement();


        ResultSet rs = stmt.executeQuery("select * from Account");

        while(rs.next()){

            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));
        }



    }
}
