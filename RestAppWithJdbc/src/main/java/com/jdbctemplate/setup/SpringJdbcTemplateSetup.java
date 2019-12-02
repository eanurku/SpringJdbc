package com.jdbctemplate.setup;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import com.dao.StudentMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.List;

public class SpringJdbcTemplateSetup {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);

        List<Student> students = studentjdbcTemplate.getJdbctemplateObj().query("select * from student", new StudentMapper());
        System.out.println(students);


    }
}
