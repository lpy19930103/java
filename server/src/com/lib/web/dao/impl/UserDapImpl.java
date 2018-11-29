package com.lib.web.dao.impl;


import com.lib.web.dao.UserDao;
import com.lib.web.domain.User;
import com.lib.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDapImpl implements UserDao {
    @Override
    public void save(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into user(uid,username,password,name,email,telephone,birthday,sex,state,code) values (?,?,?,?,?,?,?,?,?,?)";
        Object[] param = {user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(),
                user.getBirthday(), user.getSex(), user.getState(), user.getCode()};
        queryRunner.update(sql, param);
    }
}
