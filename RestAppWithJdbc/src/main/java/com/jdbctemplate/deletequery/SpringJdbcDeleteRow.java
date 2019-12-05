package com.jdbctemplate.deletequery;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcDeleteRow {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        int count = studentjdbcTemplate.deleteStudent(1);

        System.out.println("delete student count:"+count);


    }
}
