package com.dao;

import java.util.List;
import java.util.Map;

public interface StudentDAO {

     List<Student> getAllStudents();
     Student getStudent(int studentId);

     int addStudent(Student student);
     int addStudents(List<Student> students);
     int[] batchAddStudents(List<Student> students);

     int updateStudent(Student student);
     int updateStudents(List<Student>  student);
     int[] batchUpdateStudents(List<Student> students);
     int[][] restrictedBatchSizedUpdateStudents(List<Student> studentList,int batchSize);
     int[] objectBatchUpdateStudents(List<Student> students);

     Map<String,Object> callProcedure(String proc,Map<String,Object> inputParams);


}
