package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) {


        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

            PreparedStatement pstmt = conn.prepareStatement("update Account set amount=? where accno=?");

            pstmt.setInt(1,100);
            pstmt.setInt(2,10);

            int val = pstmt.executeUpdate();
            System.out.println(val);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
