package com.jdbctemplate.updatequery;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class SpringJdbcMultiBatchUpdateByParameterizedPreparedStatementSetter {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);


        List<Student> list = new ArrayList<>();
        list.add(new Student("yname5", 5432L, 271));
        list.add(new Student("yname5", 5432L, 272));
        list.add(new Student("yname5", 5432L, 273));

        int[][] count = studentjdbcTemplate.multipleBatchesUpdateStudents(list,2);

        System.out.println("update count:");
        for(int i=0;i< count.length;i++){
            System.out.print("row["+i+"]:");
            for(int j=0;j<count[i].length;j++){
                System.out.print(count[i][j]+" ");
            }
            System.out.println();
        }

    }
}
