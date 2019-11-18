package com;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        System.out.println("welcome to jdbc");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from Account");

        while(rs.next()){
            System.out.println(rs.getInt("accno")+" "+rs.getDouble("amount"));

        }


    }



}
