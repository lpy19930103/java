package com.lpy.mybatis.dao;

import com.lpy.mybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class UserMapperSpringTest {
    @Autowired
    private UserMapper mapper;

    @Test
    public void login() {
        System.out.println(mapper.login("哈哈哈", "123"));
    }

    @Test
    public void queryUserByTableName() {
        System.out.println(mapper.queryUserByTableName("user"));
    }

    @Test
    public void queryUserById() {
        System.out.println(mapper.queryUserById(2));
    }

    @Test
    public void queryUserAll() {
        System.out.println(mapper.queryUserAll());
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("张三1");
        user.setPassword("123");
        user.setSex(1);
        mapper.insertUser(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(2);
        user.setUsername("张三3333");
        user.setPassword("123");
        user.setSex(1);
        mapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        mapper.deleteUserById(3);
    }
}