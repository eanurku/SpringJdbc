package com.ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDropAndCreateDatabase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "root1234");

        Statement stmt = conn.createStatement();
        int returnValue;

        String dropDB = "drop database abc";
        String createDB = "create database abc";

        try {
            returnValue = stmt.executeUpdate(dropDB);
            System.out.println("DB dropped ... " + returnValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

        returnValue = stmt.executeUpdate(createDB);
        System.out.println("DB created ... " + returnValue);


    }
}
