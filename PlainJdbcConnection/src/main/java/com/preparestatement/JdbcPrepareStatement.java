package com.preparestatement;

import java.math.BigDecimal;
import java.sql.*;

public class JdbcPrepareStatement {
    public static void main(String[] args) throws SQLException {


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root");
        PreparedStatement pstmt;
        ResultSet rs;
        //execute
         pstmt = conn.prepareStatement("alter table Account modify  accname varchar(22)");
        System.out.println(pstmt.execute());

        //executeQuery

        pstmt=conn.prepareStatement("select * from Account");
         rs = pstmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount")+" "+rs.getString("accname"));
        }

        pstmt=conn.prepareStatement("select * from Account where accno=?");
        pstmt.setInt(1,19);

        rs = pstmt.executeQuery();

        System.out.println();
        while(rs.next()){
            System.out.println(rs.getInt("accno")+" "+rs.getBigDecimal("amount")+" "+rs.getString("accname"));
        }

        //executeUpdate update

        pstmt=conn.prepareStatement("update Account set accname=? where accno=?");
        pstmt.setInt(2,19);
        pstmt.setString(1,"savings");

        System.out.println("update count="+pstmt.executeUpdate());


        //executeUpdate insert
        pstmt=conn.prepareStatement("insert into Account set accno=?,accname=?,amount=? ");
        pstmt.setInt(1,44);
        pstmt.setString(2,"savings");
        pstmt.setBigDecimal(3,new BigDecimal(2.4));

        System.out.println("update count="+pstmt.executeUpdate());

    }
}
