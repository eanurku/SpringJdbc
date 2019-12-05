package com.jdbctemplate.storeprocedure;

import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringJdbcWithINParamsOnly {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentJdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        Map<String,Object> inParams2=new HashMap<>();
        inParams2.put("val",23);

        Map<String, Object> out2 = studentJdbcTemplate.callProcedure("testsign", inParams2);
        Map<String, Integer> map = (Map<String,Integer>)((List<Object>) out2.get("#result-set-1")).get(0);

        System.out.println("number="+map.get("number"));
        System.out.println("number="+map.get("sign"));


    }
}
