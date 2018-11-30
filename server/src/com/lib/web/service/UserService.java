package com.lib.web.service;

import com.lib.web.domain.User;

import java.sql.SQLException;

public interface UserService {
    void regist(User user) throws SQLException;

    User login(User user) throws SQLException;

    void activeUser(String code) throws SQLException;
}
