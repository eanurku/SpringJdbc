package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionWithErrorHandling {
    public static void main(String[] args) {

        Statement stmt=null;
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root1234");
            stmt = conn.createStatement();


            boolean val=stmt.execute("select * from Account");
            System.out.println("sql query returned value:"+val);

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
    }
}
