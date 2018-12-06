package com.lpy.mybatis.dao;

import com.lpy.mybatis.pojo.Student;

import java.util.List;

public interface StudentDao {

    Student queryStudentById(long id);

    List<Student> queryStudentAll();

    void insertStudent(Student student);

    void upDateStudent(Student student);

    void deleteStudent(long id);

}
