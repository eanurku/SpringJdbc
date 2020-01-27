package com.callablestatement;

import java.sql.*;

public class JdbcStoreProcWithInParamOnly {


    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root1234");

            CallableStatement cstmt = conn.prepareCall("call testsign(?)");

            cstmt.setInt(1,-3);

            ResultSet rs = cstmt.executeQuery();

            while(rs.next()){

                System.out.println("number:"+rs.getString("number")+" sign:"+rs.getString("sign"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
/*
    delimiter //;
    create procedure testsign(IN val int)
    begin
    if val>0 then select val as number ,'+' as sign;
    elseif val<0 then select val as number,'-' as sign;
    else  select val as number ,'0' as sign ;
    end if;
    end//
 */