package com.lpy.mybatis.dao;

import com.lpy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


class UserMapperTest {

    private UserMapper mapper;
    private SqlSession sqlSession;

    // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
    // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
    // 3. Statement的resultType必须和mapper接口方法的返回类型一致
    // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）

    @Before
    void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    void login() {
        System.out.println(mapper.login("哈哈哈", "123"));
    }

    @Test
    void queryUserByTableName() {
        System.out.println(mapper.queryUserByTableName("user"));
    }

    @Test
    void queryUserById() {
        System.out.println(mapper.queryUserById(2));
    }

    @Test
    void queryUserAll() {
        System.out.println(mapper.queryUserAll());
    }

    @Test
    void insertUser() {
        User user = new User();
        user.setUsername("张三1");
        user.setPassword("123");
        user.setSex(1);
        mapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setId(2);
        user.setUsername("张三3333");
        user.setPassword("123");
        user.setSex(1);
        mapper.updateUser(user);
        sqlSession.commit();
    }

    @Test
    void deleteUserById() {
        mapper.deleteUserById(3);
        sqlSession.commit();
    }
}