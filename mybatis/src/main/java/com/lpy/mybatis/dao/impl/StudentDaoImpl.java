package com.lpy.mybatis.dao.impl;

import com.lpy.mybatis.dao.StudentDao;
import com.lpy.mybatis.pojo.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private SqlSession sqlSession;

    public StudentDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Student queryStudentById(long id) {
        return sqlSession.selectOne("StudentMapper.selectStudent", id);
    }

    public List<Student> queryStudentAll() {
        return sqlSession.selectList("StudentMapper.queryStudentAll");
    }

    public void insertStudent(Student student) {
        sqlSession.insert("StudentMapper.insertStudent", student);
    }

    public void upDateStudent(Student student) {
        sqlSession.update("StudentMapper.updateStudent", student);
    }

    public void deleteStudent(long id) {
        sqlSession.delete("StudentMapper.deleteStudent", id);
    }
}
