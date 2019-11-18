package com;

import java.sql.*;

public class Demo6 {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

            CallableStatement cstmt = conn.prepareCall("call procinout(?,?,?,?)");

            cstmt.setInt(1,12);
            cstmt.setInt(2,24);
            cstmt.registerOutParameter(3,Types.INTEGER);
            cstmt.registerOutParameter(4,Types.INTEGER);

            ResultSet rs = cstmt.executeQuery();
            System.out.println(rs.toString());


            System.out.println(cstmt.getString(3));
            System.out.println(cstmt.getString(4));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
