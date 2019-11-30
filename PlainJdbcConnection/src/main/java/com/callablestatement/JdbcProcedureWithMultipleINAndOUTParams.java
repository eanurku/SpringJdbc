package com.callablestatement;

import java.sql.*;

public class JdbcProcedureWithMultipleINAndOUTParams {

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        CallableStatement cstmt = conn.prepareCall("call sumproduct(?,?,?,?)");

        cstmt.registerOutParameter(3, Types.INTEGER);
        cstmt.registerOutParameter(4, Types.INTEGER);

        cstmt.setInt(1,20);
        cstmt.setInt(2,20);

        cstmt.execute();
        System.out.println(cstmt.getInt("sum"));

        System.out.println(cstmt.getInt("prod"));



    }
}
/*  store procedure
    drop procedure if exists sumproduct;
    delimiter //;
    create procedure sumproduct(IN x int,IN y int,OUT sum int,OUT prod int)
    begin
    set sum=x+y;
    set prod=x*y;
    end;//
 */