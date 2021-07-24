package com.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentJdbcTemplate extends JdbcDaoSupport implements StudentDAO {

    DataSource datasourceobj;
    JdbcTemplate jdbctemplateObj;

    public StudentJdbcTemplate(DataSource datasource) {

        this.datasourceobj = datasource;
        jdbctemplateObj = new JdbcTemplate(datasource);
        setDataSource(datasource);
    }

    public DataSource getDatasourceobj() {
        return datasourceobj;
    }

    public JdbcTemplate getJdbctemplateObj() {
        return jdbctemplateObj;
    }


    public List<Student> getAllStudents() {

        String SQL = "select * from student";
        List<Student> list = getJdbcTemplate().query(SQL, new StudentMapper());
        return list;
    }

    @Override
    public Student getStudent(int studentId) {

        String SQL = "select * from student where id=" + studentId;
        Student student = jdbctemplateObj.queryForObject(SQL, new StudentMapper());
        return student;
    }

    @Override
    public int addStudent(Student student) {

        String SQL_INSERT = "insert into student (name,contact) values(?,?)";
        int count = jdbctemplateObj.update(SQL_INSERT, student.getSname(), student.getScontact());
        return count;
    }

    @Override
    public int addStudents(List<Student> students) {

        int count = 0;
        String SQL_INSERT = "insert into student (name,contact) values(?,?)";
        for (Student student : students) {
            count += jdbctemplateObj.update(SQL_INSERT, student.getSname(), student.getScontact());
        }
        return count;
    }

    /*
      batch insert by jdbcTemplate,BatchPreparedStatementSetter
     */
    @Override
    public int[] batchAddStudents(List<Student> students) {

        String SQL = "insert into student set name=?,contact=?";
        int updateCount[] = jdbctemplateObj.batchUpdate(SQL, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {

                ps.setString(1, students.get(i).getSname());
                ps.setString(2, students.get(i).getScontact().toString());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }
        });

        return updateCount;


    }

    /*
    batch insert with JdbcTemplate, ParameterizedPreparedStatementSetter
     */
    @Override
    public int[][] multipleBatchesAddStudents(List<Student> studentList, int batchSize) {

        String SQL_INSERT="insert into student  set name=?,contact=?";

        int[][] count = jdbctemplateObj.batchUpdate(SQL_INSERT, studentList, batchSize, new ParameterizedPreparedStatementSetter<Student>() {
            @Override
            public void setValues(PreparedStatement ps, Student student) throws SQLException {

                ps.setString(1,student.getSname());
                ps.setString(2,student.getScontact().toString());
            }
        });
        return count;
    }


    @Override
    public int[] objectBatchAddStudents(List<Student> students) {
        return new int[0];
    }

    @Override
    public int updateStudent(Student student) {

        int count = 0;
        String SQL_UPDATE = "update student set name=?,contact=? where id=?";
        count = jdbctemplateObj.update(SQL_UPDATE, student.getSname(), student.getScontact(), student.getSid());

        return count;
    }

    @Override
    public int updateStudents(List<Student> students) {

        int count = 0;
        String SQL_UPDATE = "update student set name=?,contact=? where id=?";

        for(Student student:students)
        count += jdbctemplateObj.update(SQL_UPDATE, student.getSname(), student.getScontact(), student.getSid());

        return count;
    }

    /*
       batch update by jdbcTemplate ,BatchPreparedStatementSetter
     */
    @Override
    public int[] batchUpdateStudents(List<Student> students) {

        String SQL = "update student set name=?,contact=? where id=?";

        int[] count = jdbctemplateObj.batchUpdate(SQL, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, students.get(i).getSname());
                ps.setString(2, students.get(i).getScontact().toString());
                ps.setInt(3, students.get(i).getSid());

            }

            @Override
            public int getBatchSize() {
                return students.size();
            }
        });
        return count;
    }
    /*
      batch update by jdbcTemplate,ParameterizedPreparedStatementSetter
      restriction on batch size
     */

    public int[][] multipleBatchesUpdateStudents(List<Student> studentList,int batchSize){

        String SQL="update student set name=?,contact=? where id=?";

        int updateCount[][]=jdbctemplateObj.batchUpdate(SQL, studentList, batchSize, new ParameterizedPreparedStatementSetter<Student>() {
            @Override
            public void setValues(PreparedStatement ps, Student student) throws SQLException {

                ps.setString(1,student.getSname());
                ps.setString(2,student.getScontact().toString());
                ps.setInt(3,student.getSid());
            }
        });

        return updateCount;
    }

    @Override
    public Map<String, Object> callProcedure(String proc, Map<String, Object> inputParams) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(datasourceobj).withProcedureName(proc);
        SqlParameterSource in = new MapSqlParameterSource().addValues(inputParams);
        Map<String, Object> out = jdbcCall.execute(in);
        return out;
    }

    @Override
    public int[] objectBatchUpdateStudents(List<Student> students) {
        return new int[0];
    }


    public int deleteStudent(int studentId){

        String SQL_DELETE="delete from student where id=?";
        int count = jdbctemplateObj.update(SQL_DELETE, studentId);
        return count;

    }

}
