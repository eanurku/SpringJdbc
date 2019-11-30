package com.resultset;

import java.math.BigDecimal;
import java.sql.*;

public class JdbcResultSetUpdateRow {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);


        ResultSet rs = stmt.executeQuery("select * from Account");

        System.out.println("table before update :");
        while (rs.next()){

            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));

        }

        //update a row
        rs.absolute(3);
        System.out.println("updating below row:");
        System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));

        rs.updateBigDecimal(2,new BigDecimal(33.33));

        rs.updateRow();


        System.out.println("table after update :");
        rs.beforeFirst();

        while (rs.next()){

            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));

        }

    }
}
