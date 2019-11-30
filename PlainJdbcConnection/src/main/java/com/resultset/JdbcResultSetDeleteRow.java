package com.resultset;

import java.sql.*;

public class JdbcResultSetDeleteRow {
    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = stmt.executeQuery("select * from Account");

        System.out.println("table rows before delete");
        while(rs.next()){

            System.out.println(rs.getInt("accno")+" "+rs.getString("amount"));
        }


        //delete a row
        int deleteRow=1;
        rs.absolute(deleteRow);

        System.out.println("deleting below row:");
        System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));

        rs.deleteRow();

        System.out.println("table rows after  delete :");
        while(rs.next()){

            System.out.println(rs.getInt("accno")+" "+rs.getString("amount"));
        }






    }
}
