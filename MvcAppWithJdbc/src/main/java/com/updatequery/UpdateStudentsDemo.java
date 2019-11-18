package com.updatequery;

import com.dao.Student;
import com.dao.StudentJdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UpdateStudentsDemo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-dispatch-servlet.xml");
        StudentJdbcTemplate studentjdbcTemplate = context.getBean("studentJdbcTemplate", StudentJdbcTemplate.class);

        //ex 1
        System.out.println("update count="+studentjdbcTemplate.updateStudent(new Student("sx",90L,2)));


        //ex 2
        List<Student> listofstudents=new ArrayList<>();
        listofstudents.add(new Student("sx1",98L,250));
        listofstudents.add(new Student("sx2",97L,253));
        listofstudents.add(new Student("sx3",96L,255));

        System.out.println("update count="+studentjdbcTemplate.batchUpdateStudents(listofstudents).length);

        //ex 3
        List<Student> listofstudents1=new ArrayList<>();
        listofstudents1.add(new Student("sx11",98L,250));
        listofstudents1.add(new Student("sx22",97L,253));
        listofstudents1.add(new Student("sx33",96L,255));

        System.out.println("update count="+studentjdbcTemplate.objectBatchUpdateStudents(listofstudents1).length);

        //ex 4
        List<Student> listofstudents2=new ArrayList<>();
        listofstudents2.add(new Student("sx11",9899L,250));
        listofstudents2.add(new Student("sx22",9799L,253));
        listofstudents2.add(new Student("sx33",9699L,255));

        int count[][]=studentjdbcTemplate.restrictedBatchSizedUpdateStudents(listofstudents2);

        System.out.println(count.length);
    }
}
