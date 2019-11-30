package com.callablestatement;

import java.sql.*;

public class JdbcStoreProcWithoutAnyParams {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

            CallableStatement cstmt = conn.prepareCall("call getAccounts()");
            ResultSet rs = cstmt.executeQuery();

            while(rs.next()){

                System.out.println(rs.getString("accno"));
            }

            System.out.println(cstmt.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
/*
    delimiter //;
    create procedure getAccounts()
    select * from Account;//
 */

/*
below error will be thrown after returning result:
java.sql.SQLException: No output parameters registered.
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:89)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:63)
	at com.mysql.cj.jdbc.CallableStatement.getOutputParameters(CallableStatement.java:1457)
	at com.mysql.cj.jdbc.CallableStatement.getString(CallableStatement.java:1534)
	at com.callablestatement.JdbcStoreProcWithoutAnyParams.main(JdbcStoreProcWithoutAnyParams.java:20)

 */