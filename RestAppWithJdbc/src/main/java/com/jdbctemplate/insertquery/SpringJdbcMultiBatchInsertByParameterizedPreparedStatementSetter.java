package com.jdbctemplate.insertquery;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcMultiBatchInsertByParameterizedPreparedStatementSetter {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbctemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);

        List<Student> list=new ArrayList<>();
        list.add(new Student("sx1",543L));
        list.add(new Student("sx2",542L));
        list.add(new Student("sx3",541L));
        int[][] count = studentjdbctemplate.multipleBatchesAddStudents(list,2);


    }
}
