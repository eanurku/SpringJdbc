package com;

import java.sql.*;

public class Demo4 {


    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

            CallableStatement cstmt = conn.prepareCall("call testsign(?)");

            cstmt.setInt(1,-3);
            //cstmt.registerOutParameter(1, Types.VARCHAR);
            ResultSet rs = cstmt.executeQuery();

            while(rs.next()){

                System.out.println("number:"+rs.getString("number")+" sign:"+rs.getString("sign"));
            }

           // System.out.println(cstmt.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
