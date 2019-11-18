package com.dao;

import java.util.List;
import java.util.Map;

public interface StudentDAO {

     List<Student> getStudents();
     Student getStudent(int studentId);

     int addStudent(Student student);
     int addStudents(List<Student> students);
     int[] batchAddStudents(List<Student> students);

     int updateStudent(Student student);
     int[] batchUpdateStudents(List<Student> students);

     Map<String,Object> callProcedure(String proc,Map<String,Object> inputParams);

     int[] objectBatchUpdateStudents(List<Student> students);
}
