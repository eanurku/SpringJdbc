package com.namedparameterjdbctemplate.updatequery;

import com.dao.Student;
import com.dao.StudentNamedParameterTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcBatchUpdate {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentNamedParameterTemplate studentNamedParameterTemplate = context.getBean("studentNamedParameterJdbcTemplate", StudentNamedParameterTemplate.class);


        List<Student> list = new ArrayList<>();
        list.add(new Student("yname3", 5432L, 271));
        list.add(new Student("yname3", 5432L, 272));
        list.add(new Student("yname3", 5432L, 273));
        int[] count = studentNamedParameterTemplate.objectBatchUpdateStudents(list);

        System.out.println("update count:");

        for(int i=0;i<count.length;i++){
            System.out.println(count[i]);
        }
    }
}
