package com.lib.web.servlet;

import com.lib.web.base.BaseServlet;
import com.lib.web.domain.User;
import com.lib.web.service.impl.UserServiceImpl;
import com.lib.web.utils.MyBeanUtils;
import com.lib.web.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserServlet extends BaseServlet {

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("findAll");

    }

    public String registUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "/jsp/register.jsp";
    }

    public String regist(HttpServletRequest req, HttpServletResponse res) throws SQLException {

        User user = MyBeanUtils.populate(User.class, req.getParameterMap());
        user.setUid(UUIDUtils.getUUID());
        user.setCode(UUIDUtils.getUUID64());
        user.setState(0);
        UserServiceImpl userService = new UserServiceImpl();
        userService.regist(user);
        req.setAttribute("msg", "注册成功，请邮件激活后在登录");

        return "/jsp/login.jsp";

    }
}
