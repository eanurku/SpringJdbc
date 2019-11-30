package com.statement;

import java.sql.*;

public class JdbcStatementExecuteForDDL {

    public static void main(String[] args) throws SQLException{


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");
        Statement stmt = conn.createStatement();


            boolean val=stmt.execute("alter table Account modify amount decimal(5,3) not null");

            System.out.println("sql query returned value:"+val);

            stmt.close();
            conn.close();



    }
}
