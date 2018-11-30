package com.lib.web.dao.impl;


import com.lib.web.dao.UserDao;
import com.lib.web.domain.User;
import com.lib.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into user(uid,username,password,name,email,telephone,birthday,sex,state,code) values (?,?,?,?,?,?,?,?,?,?)";
        Object[] param = {user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(),
                user.getBirthday(), user.getSex(), user.getState(), user.getCode()};
        queryRunner.update(sql, param);
    }

    @Override
    public void update(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "update user set username =?, password=?, name=?, email=?, telephone=?, birthday=?, sex=?, state=?, code=? where uid=?";
        Object[] param = {user.getUsername(), user.getPassword(), user.getName(), user.getEmail(),
                user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode(), user.getUid()};
        queryRunner.update(sql, param);

    }

    @Override
    public User findUserByCode(String code) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from user where code = ?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), code);
        return user;
    }
}
