package com.lpy.mybatis.dao;

import com.lpy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public User login(@Param("userName") String userName, @Param("passWord") String passWord);

    public List<User> queryUserByTableName(@Param("tableName") String tableName);

    public User queryUserById(@Param("id") int id);

    public List<User> queryUserAll();

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUserById(int id);
}
