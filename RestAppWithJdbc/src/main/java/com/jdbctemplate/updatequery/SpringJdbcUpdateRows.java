package com.jdbctemplate.updatequery;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcUpdateRows {
    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        List<Student> list=new ArrayList<>();
        list.add(new Student("yname1",5432L,271));
        list.add(new Student("yname1",5432L,272));
        list.add(new Student("yname1",5432L,273));

        int count=studentjdbcTemplate.updateStudents(list);

        System.out.println("update count:"+count);
    }
}
