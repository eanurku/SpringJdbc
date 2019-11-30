package com.streaming;

import sun.reflect.annotation.ExceptionProxy;

import java.io.*;
import java.sql.*;

public class JdbcPrepareStmtHandlesLargeData {
    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {


        String infilepath = JdbcPrepareStmtHandlesLargeData.class.getResource("sampletest.xml").getPath();
        FileInputStream finputstream = new FileInputStream(infilepath);

        String outfilepath = JdbcPrepareStmtHandlesLargeData.class.getResource("out.xml").getPath();
        FileOutputStream foutputstream = new FileOutputStream(outfilepath);

        int c;

//        while((c=finputstream.read())!=-1){
//            foutputstream.write(c);
//
//        }
//        foutputstream.flush();


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
        createTableForData(conn);
        System.out.println("table created=");


                PreparedStatement pstmt = conn.prepareStatement("insert into DataTable set id=?,data=?");

        pstmt.setInt(1, 120);
        pstmt.setAsciiStream(2, finputstream);
        pstmt.executeUpdate();


        ResultSet rs = pstmt.executeQuery("select data from DataTable where id=120");

        while (rs.next()) {
            InputStream datastream = rs.getAsciiStream("data");

            while ((c = datastream.read()) != -1) {
                System.out.print((char)(c));
            }

        }


    }

    static boolean createTableForData(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        String createsql = "create table DataTable(id int,data LONG)";
        String droptable = "drop table DataTable ";

        try {
            stmt.execute(droptable);

        } catch (Exception e) {
            e.printStackTrace();
        }


        boolean val = stmt.execute(createsql);

        return val;

    }
}
