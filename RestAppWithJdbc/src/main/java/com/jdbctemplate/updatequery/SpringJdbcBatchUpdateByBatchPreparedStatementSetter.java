package com.jdbctemplate.updatequery;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcBatchUpdateByBatchPreparedStatementSetter {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        List<Student> list = new ArrayList<>();
        list.add(new Student("yname2", 5432L, 271));
        list.add(new Student("yname2", 5432L, 272));
        list.add(new Student("yname2", 5432L, 273));


        int[] count = studentjdbcTemplate.batchUpdateStudents(list);

        System.out.println("update count:");
        for(int i=0;i<count.length;i++)
            System.out.println(count[i]);

    }
}
