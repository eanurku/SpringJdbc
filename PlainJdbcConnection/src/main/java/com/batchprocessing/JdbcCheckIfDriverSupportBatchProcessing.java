package com.batchprocessing;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcCheckIfDriverSupportBatchProcessing {

    public static void main(String[] args) throws SQLException,ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");

        DatabaseMetaData dbmetadata = conn.getMetaData();

        System.out.println("jdbc driver supports BatchUpdates :"+dbmetadata.supportsBatchUpdates());




    }
}
