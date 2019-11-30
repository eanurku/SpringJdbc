package com.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class StudentJdbcTemplate implements StudentDAO {

    DataSource datasourceobj;
    JdbcTemplate jdbctemplateObj;

    public StudentJdbcTemplate(DataSource datasource) {

        this.datasourceobj = datasource;
        jdbctemplateObj = new JdbcTemplate(datasource);
    }

    public DataSource getDatasourceobj() {
        return datasourceobj;
    }

    public JdbcTemplate getJdbctemplateObj() {
        return jdbctemplateObj;
    }

    public List<Student> getStudents() {

        String SQL = "select * from student";
        List<Student> list = jdbctemplateObj.query(SQL, new StudentMapper());
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

    @Override
    public int updateStudent(Student student) {

        int count = 0;
        String SQL_UPDATE = "update student set name=?,contact=? where id=?";
        count = jdbctemplateObj.update(SQL_UPDATE, student.getSname(), student.getScontact(), student.getSid());

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
      batch update by NamedParameterJdbcTemplate,SqlParameterSource
     */
    @Override
    public int[] objectBatchUpdateStudents(List<Student> students) {


        String SQL = "update student set name=:sname,contact=:scontact where id=:sid";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(students.toArray());

        NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(datasourceobj);
        int[] count = namedJdbcTemplate.batchUpdate(SQL, batch);
        return count;
    }

    /*
      batch update by jdbcTemplate,ParameterizedPreparedStatementSetter
      restriction on batch size
     */

    public int[][] restrictedBatchSizedUpdateStudents(List<Student> studentList){

        String SQL="update student set name=?,contact=? where id=?";
        int BATCH_SIZE=2;

        int updateCount[][]=jdbctemplateObj.batchUpdate(SQL, studentList, BATCH_SIZE, new ParameterizedPreparedStatementSetter<Student>() {
            @Override
            public void setValues(PreparedStatement ps, Student argument) throws SQLException {

                ps.setString(1,argument.getSname());
                ps.setString(2,argument.getScontact().toString());
                ps.setInt(3,argument.getSid());
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





}
