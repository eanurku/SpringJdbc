package com.transaction;

import java.sql.*;

public class JdbcConnectionAutoCommitFalse {

    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "root");

        ResultSet rs=null;

        try {
            Statement stmt = conn.createStatement();

            conn.setAutoCommit(false);

            stmt.executeUpdate("insert into Account set accno=125,amount=12.22");

            stmt.executeUpdate("insert into Account set accno=126");
            stmt.executeUpdate("insert into Account set accno=127,amount=12.22");


             rs = stmt.executeQuery("select * from Account");


            conn.commit();
        }
        catch(SQLException e){
            conn.rollback();

            System.out.println("Error details: "+e.getErrorCode()+" :"+e.getMessage()+" :"+e.getSQLState());
            System.out.println();
            e.printStackTrace();
        }catch(Exception e){

            e.printStackTrace();
        }



        while(rs!=null && rs.next()){

            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount"));
        }


    }
}
/*
None of executeUpdate statement will succeed as second update query is going to throw SQl error.
connection rollback will happen and below error will be logged:

java.sql.SQLException: Field 'amount' doesn't have a default value
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129)
	at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:97)
	at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	at com.mysql.cj.jdbc.StatementImpl.executeUpdateInternal(StatementImpl.java:1335)
	at com.mysql.cj.jdbc.StatementImpl.executeLargeUpdate(StatementImpl.java:2108)
	at com.mysql.cj.jdbc.StatementImpl.executeUpdate(StatementImpl.java:1245)
	at com.transaction.JdbcConnectionAutoCommitFalse.main(JdbcConnectionAutoCommitFalse.java:20)
 */