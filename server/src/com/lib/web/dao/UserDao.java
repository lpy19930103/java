package com.lib.web.dao;

import com.lib.web.domain.User;

import java.sql.SQLException;

public interface UserDao {
    public void save(User user) throws SQLException;
}
