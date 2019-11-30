package com.batchprocessing;

import java.sql.*;
import java.util.Arrays;

public class JdbcStatementBatchProcessing {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");
        Statement stmt = conn.createStatement();

        conn.setAutoCommit(false);

        try {
            String sql1 = "insert into Account set accno=314,amount=21.2";
            stmt.addBatch(sql1);

            String sql2 = "insert into Account set accno=315,amount=21.2";
            stmt.addBatch(sql2);

            String sql3 = "insert into Account set accno=313,amount=21.2";
            stmt.addBatch(sql3);

            int[] count = stmt.executeBatch();
            conn.commit();

            for (int i = 0; i < count.length; i++) {
                System.out.println("count=" + count[i]);
            }

        } catch (BatchUpdateException e) {
            conn.rollback();
            System.out.println("Error: " + e.getErrorCode() + " :" + e.getSQLState());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
