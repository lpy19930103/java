package com.lpy.mybatis.dao;

import com.lpy.mybatis.dao.impl.StudentDaoImpl;
import com.lpy.mybatis.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class StudentDaoTest {
    private StudentDao studentDao;
    private SqlSession sqlSession;

    @BeforeEach
    void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = factory.openSession();
        studentDao = new StudentDaoImpl(sqlSession);
    }

    @Test
    void queryStudentById() {
        System.out.println(studentDao.queryStudentById(5).toString());
    }

    @Test
    void queryStudentAll() {
        List<Student> students = studentDao.queryStudentAll();
        System.out.println(students.toString());
    }

    @Test
    void insertStudent() {
        Student student = new Student();
        student.setName("哈哈哈");
        student.setAge(80);
        student.setScore("99");
        student.setSex("1");
        student.setClazz("班级");
        studentDao.insertStudent(student);
        sqlSession.commit();
    }

    @Test
    void upDateStudent() {
        Student student = new Student();
        student.setName("哈哈哈");
        student.setAge(80);
        student.setId(3L);
        student.setScore("99");
        student.setSex("1");
        student.setClazz("班级123321");
        studentDao.upDateStudent(student);
        sqlSession.commit();
    }

    @Test
    void deleteStudent() {
        studentDao.deleteStudent(2);
        sqlSession.commit();
    }
}