package com.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcProcWithINOUTParam {

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        CallableStatement cstmt = conn.prepareCall("call getfactorial(?)");

        cstmt.setInt(1,5);
        cstmt.execute();

        System.out.println(cstmt.getInt("number"));


    }
}
/*
    delimiter //;
    create procedure getfactorial(INOUT number int)
    begin
    declare result int;
    declare i int;
    set i=1;
    set result=1;
    while i<=number do
     set result=result*i;
     set i=i+1;
     end while;
    set number=result;
    end;//
 */