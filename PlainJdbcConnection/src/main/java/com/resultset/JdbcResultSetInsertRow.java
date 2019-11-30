package com.resultset;

import java.math.BigDecimal;
import java.sql.*;

public class JdbcResultSetInsertRow {

    public static void main(String[] args) throws SQLException, InterruptedException {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from Account");

        System.out.println("table before insert:");
        while(rs.next()){
            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));
        }

        //insert a row

        rs.moveToInsertRow();
        rs.updateInt(1,21);
        rs.updateBigDecimal(2,new BigDecimal(34.56));
        rs.insertRow();


        System.out.println("below row inserted :");
        System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));


        System.out.println("table after insert:");

        rs.beforeFirst();
        while(rs.next()){
            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));
        }


        rs.close();
        stmt.close();
        conn.close();



    }


}
