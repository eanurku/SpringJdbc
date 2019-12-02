package com.namedparameterjdbctemplate.setup;

import com.dao.StudentNamedParameterTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcNamedParameterJdbcTemplateSetup {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentNamedParameterTemplate studentNamedParameterTemplate = context.getBean("studentNamedParameterJdbcTemplate", StudentNamedParameterTemplate.class);


        System.out.println(studentNamedParameterTemplate.getAllStudents());

    }
}
