package com.batchprocessing;

import java.math.BigDecimal;
import java.sql.*;

public class JdbcPrepareStmtBatchProcessing {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");

        try {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("insert into Account set accno=?,amount=?");

            pstmt.setInt(1, 411);
            pstmt.setBigDecimal(2, new BigDecimal("34.4"));
            pstmt.addBatch();


            pstmt.setInt(1, 412);
            pstmt.setBigDecimal(2, new BigDecimal("35.4"));
            pstmt.addBatch();

            pstmt.setInt(1, 413);
            pstmt.setBigDecimal(2, new BigDecimal("33.4"));
            pstmt.addBatch();

            int[] count = pstmt.executeBatch();

            conn.commit();
            for (int i = 0; i < count.length; i++) {
                System.out.println("count=" + count[i]);
            }

        }catch(BatchUpdateException e){
            conn.rollback();
            System.out.println("Error: "+e.getErrorCode()+": "+e.getSQLState());
            e.printStackTrace();

        }catch(Exception e){
            e.printStackTrace();
        }




    }
}
