package com.ddl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDropAndCreateTable {
    public static void main(String[] args) throws SQLException,ClassNotFoundException {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

        Statement stmt = conn.createStatement();


        String dropTable = "drop table temptable";

        String createTable="create table temptable(id int,name varchar(12))";
        int returnVal;

        try {
          returnVal=  stmt.executeUpdate(dropTable);
            System.out.println("table dropped :"+returnVal);

        }catch(Exception e){
            e.printStackTrace();
        }

        returnVal=stmt.executeUpdate(createTable);
        System.out.println("table created :"+returnVal);


    }
}
