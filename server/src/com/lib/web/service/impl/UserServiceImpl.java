package com.lib.web.service.impl;

import com.lib.web.dao.impl.UserDaoImpl;
import com.lib.web.domain.User;
import com.lib.web.service.UserService;
import com.lib.web.utils.MailUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public void regist(User user) throws SQLException {
        new UserDaoImpl().save(user);

        MailUtils.sendMail(user.getEmail(), user.getCode());
    }

    @Override
    public User login(User user) throws SQLException {
        return new UserDaoImpl().login(user);
    }

    @Override
    public void activeUser(String code) throws SQLException {
        User user = new UserDaoImpl().findUserByCode(code);
        if (user == null) {
            throw new RuntimeException("用户激活码失效，请从新发送");
        }
        user.setState(1);
        user.setCode(null);
        new UserDaoImpl().update(user);

    }

    @Override
    public User findByUserName(String userName) throws SQLException {
        return new UserDaoImpl().findUserByName(userName);
    }


}
