package com.lib.web.dao;

import com.lib.web.domain.User;

import java.sql.SQLException;

public interface UserDao {
    void save(User user) throws SQLException;

    void update(User user) throws SQLException;

    User login(User user) throws SQLException;

    User findUserByCode(String code) throws SQLException;
}
