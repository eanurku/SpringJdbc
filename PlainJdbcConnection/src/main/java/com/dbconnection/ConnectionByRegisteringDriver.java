package com.dbconnection;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class ConnectionByRegisteringDriver {
    public static void main(String[] args) throws SQLException {


        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root1234");

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from Account");

        while(rs.next()){

            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));

        }


    }
}
