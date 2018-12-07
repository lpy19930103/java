package com.lpy.mybatis.dao;

import com.lpy.mybatis.dao.impl.UserDao;
import com.lpy.mybatis.dao.impl.UserDaoImpl;
import com.lpy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

class UserDaoTest {
    private UserDao userDao;
    private SqlSession sqlSession;

    @Before
    void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = factory.openSession();
        userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    void queryStudentById() {
        System.out.println(userDao.queryUserById(2).toString());
    }

    @Test
    void queryStudentAll() {
        System.out.println(userDao.queryUserAll());
    }

    @Test
    void insertStudent() {
        User user = new User();
        user.setUsername("哈哈哈");
        user.setPassword("123");
        user.setSex(1);
        userDao.insertUser(user);
        sqlSession.commit();
    }

    @Test
    void upDateStudent() {
        User user = new User();
        user.setId(2);
        user.setUsername("哈哈哈123312");
        user.setPassword("123");
        user.setSex(1);
        userDao.upDateUser(user);
        sqlSession.commit();
    }

    @Test
    void deleteStudent() {
        userDao.deleteUser(1);
        sqlSession.commit();
    }
}