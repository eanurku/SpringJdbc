package com;

import java.sql.*;

public class Demo1 {

    public static void main(String[] args) {

        System.out.println("starting connnection  to mysql...");
        Statement stmt=null;
        Connection conn=null;
        try {
             conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");
             stmt = conn.createStatement();


            System.out.println("execute method of statement :"+stmt.execute("select * from Account"));
            System.out.println("executeupdate method of statement:"+stmt.executeUpdate("insert into Account set accno=10"));

            ResultSet rs = stmt.executeQuery("select * from customers");

            while(rs.next()){
                String name = rs.getString("cname");
                Date cdob=rs.getDate("cdob");
                System.out.println("name:"+name);
                System.out.println("date:"+cdob);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("stopping connnection  to mysql...");

    }
}
