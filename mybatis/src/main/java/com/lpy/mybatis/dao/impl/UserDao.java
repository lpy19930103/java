package com.lpy.mybatis.dao.impl;

import com.lpy.mybatis.pojo.User;

import java.util.List;

public interface UserDao {

    User queryUserById(long id);

    List<User> queryUserAll();

    void insertUser(User student);

    void upDateUser(User student);

    void deleteUser(long id);

}
