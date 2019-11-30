package com.selectquery;

import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetStudentsDemo {

    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        //ex 1
        System.out.println( studentjdbcTemplate.getStudents());

        //ex 2
        System.out.println(studentjdbcTemplate.getStudent(1));



    }
    

}
