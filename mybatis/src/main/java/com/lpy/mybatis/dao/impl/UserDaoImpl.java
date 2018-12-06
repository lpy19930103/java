package com.lpy.mybatis.dao.impl;

import com.lpy.mybatis.dao.UserDao;
import com.lpy.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User queryStudentById(long id) {
        return sqlSession.selectOne("UserDaoMapper.selectUser", id);
    }

    public List<User> queryStudentAll() {
        return sqlSession.selectList("UserDaoMapper.queryUserAll");
    }

    public void insertStudent(User student) {
        sqlSession.insert("UserDaoMapper.insertUser", student);
    }

    public void upDateStudent(User student) {
        sqlSession.update("UserDaoMapper.updateUser", student);
    }

    public void deleteStudent(long id) {
        sqlSession.delete("UserDaoMapper.deleteUser", id);
    }

    public User queryUserById(long id) {
        return null;
    }

    public List<User> queryUserAll() {
        return null;
    }

    public void insertUser(User student) {

    }

    public void upDateUser(User student) {

    }

    public void deleteUser(long id) {

    }
}
