package com.insertquery;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class InsertStudentsDemo {

    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        //ex 1
        System.out.println("insert count="+studentjdbcTemplate.addStudent(new Student("abc",132L)));

        //ex 2
        List<Student> listofstudents=new ArrayList<>();
        listofstudents.add(new Student("s1",12L));
        listofstudents.add(new Student("s2",13L));
        listofstudents.add(new Student("s3",14L));

        System.out.println("insert count="+studentjdbcTemplate.addStudents(listofstudents));

        //ex 3
        List<Student> batchofstudents=new ArrayList<>();
        batchofstudents.add(new Student("b1",22L));
        batchofstudents.add(new Student("b2",23L));
        batchofstudents.add(new Student("b3",24L));

        System.out.println("insert batch count="+studentjdbcTemplate.batchAddStudents(batchofstudents).length);

    }
}
