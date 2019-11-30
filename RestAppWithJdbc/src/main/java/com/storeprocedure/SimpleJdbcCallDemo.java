package com.storeprocedure;

import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class SimpleJdbcCallDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentJdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        //ex 1
        Map<String,Object> inParams=new HashMap<>();
        inParams.put("x",4);
        inParams.put("y",7);

        Map<String, Object> out = studentJdbcTemplate.callProcedure("procinout", inParams);

        System.out.println("sum="+out.get("sum"));
        System.out.println("prod="+out.get("prod"));



    }
}
