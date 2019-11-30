package com.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {


        Student student=new Student();

        student.setSid(rs.getInt("id"));
        student.setSname(rs.getString("name"));
        student.setScontact(Long.parseLong(rs.getString("contact")));


        return student;
    }
}
