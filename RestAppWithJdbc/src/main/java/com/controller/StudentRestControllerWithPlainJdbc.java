package com.controller;


import com.dao.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/plainjdbc")
@RestController
public class StudentRestControllerWithPlainJdbc {


    @RequestMapping(value = "/testget", produces = MediaType.APPLICATION_XML_VALUE,method = RequestMethod.GET)
    public List<Student> testget() {

        List<Student> list = new ArrayList<>();
        list.add(new Student("monu",232L));
        list.add(new Student("gonu",321L));

        return list;
    }

    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    public ResponseEntity<Boolean> testpost( @RequestBody Student student) {


        System.out.println("student details for creating record:" + student);


        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public ResponseEntity<Boolean> addStudent(@RequestBody Student student) throws SQLException, ClassNotFoundException {


        System.out.println("starting connnection  to mysql...");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","root");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("insert into student set name="+"\""+student.getSname()+"\""+",contact="+"\""+student.getScontact()+"\"");
        conn.close();
        stmt.close();

        return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getStudent/{name}",method = RequestMethod.GET)
    public List<Student> getStudent(@PathVariable ("name") String sname)throws SQLException, ClassNotFoundException{

        System.out.println("student name:"+sname);
        List<Student> list=new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","root");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from student where name="+"\""+sname+"\"");

        while(rs.next()){
            Student student=new Student();
            student.setSid(rs.getInt("id"));
            student.setSname(rs.getString("name"));
            student.setScontact(Long.parseLong(rs.getString("contact")));
           list.add(student);
        }
        conn.close();
        stmt.close();
        rs.close();

        return list;
    }


}
