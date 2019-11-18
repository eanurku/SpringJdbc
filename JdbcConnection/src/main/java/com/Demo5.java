package com;

import java.sql.*;

public class Demo5 {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

            CallableStatement cstmt = conn.prepareCall("call getcustomers()");

            ResultSet rs = cstmt.executeQuery();

            while(rs.next()){

                System.out.println(rs.getString("cname"));
            }

            System.out.println(cstmt.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
