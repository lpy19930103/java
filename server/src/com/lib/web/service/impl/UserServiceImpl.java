package com.lib.web.service.impl;

import com.lib.web.dao.impl.UserDapImpl;
import com.lib.web.domain.User;
import com.lib.web.service.UserService;
import com.lib.web.utils.MailUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public void regist(User user) throws SQLException {
        new UserDapImpl().save(user);

        MailUtils.sendMail(user.getEmail(), user.getCode());
    }
}
