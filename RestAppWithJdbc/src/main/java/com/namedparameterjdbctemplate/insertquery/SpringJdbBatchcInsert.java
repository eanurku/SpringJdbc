package com.namedparameterjdbctemplate.insertquery;

import com.dao.Student;
import com.dao.StudentNamedParameterTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbBatchcInsert {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentNamedParameterTemplate studentNamedParameterTemplate = context.getBean("studentNamedParameterJdbcTemplate", StudentNamedParameterTemplate.class);


        List<Student> list = new ArrayList<>();
        list.add(new Student("zname3", 5432L));
        list.add(new Student("zname3", 5432L));
        list.add(new Student("zname3", 5432L));

        studentNamedParameterTemplate.objectBatchAddStudents(list);

    }
}
