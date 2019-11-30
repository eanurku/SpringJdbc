package com.callablestatement;

import java.sql.*;

public class JdbcProcWithINAndOUTparams {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        CallableStatement cstmt = conn.prepareCall("call getamount(?,?)");

        cstmt.registerOutParameter(2, Types.NUMERIC);


        cstmt.setInt(1,20);


        cstmt.execute();
        System.out.println(cstmt.getBigDecimal("amountv"));

    }
}
/* store procedure

     drop procedure if exists getamount;
     delimiter //;;
     create procedure getamount(IN account int,OUT amountv decimal(5,3) )
     begin
     select amount into amountv
     from Account
     where accno=account;
     end;//

*/