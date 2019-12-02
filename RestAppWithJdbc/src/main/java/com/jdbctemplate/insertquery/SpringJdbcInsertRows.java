package com.jdbctemplate.insertquery;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcInsertRows {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        List<Student> list = new ArrayList<>();
        list.add(new Student("xname1", 213L));
        list.add(new Student("xname2", 214L));

        int count = studentjdbcTemplate.addStudents(list);
        System.out.println("inserted rows:"+count);


    }
}
