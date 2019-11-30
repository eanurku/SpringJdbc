package com.preparestatement;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPrepareStementReuse {
    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

        PreparedStatement pstmt;
        //ex 1
        pstmt = conn.prepareStatement("update Account set amount=? where accno=?");

        pstmt.setBigDecimal(1, new BigDecimal(22.3));
        pstmt.setInt(2, 19);

        System.out.println("update count="+pstmt.executeUpdate());

        //ex 2
        pstmt.setBigDecimal(1,new BigDecimal(24.3));
        pstmt.setInt(2,20);
        System.out.println("update count="+pstmt.executeUpdate());



    }
}
