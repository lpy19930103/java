package com.lib.web.servlet;

import com.lib.web.base.BaseServlet;
import com.lib.web.domain.User;
import com.lib.web.service.impl.UserServiceImpl;
import com.lib.web.utils.MyBeanUtils;
import com.lib.web.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

    public String loginUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "/jsp/login.jsp";
    }

    public String regist(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        System.out.println("注册成功" + req.getParameterMap().toString());
        User user = MyBeanUtils.populate(User.class, req.getParameterMap());
        user.setUid(UUIDUtils.getUUID());
        user.setCode(UUIDUtils.getUUID64());
        user.setState(0);
        UserServiceImpl userService = new UserServiceImpl();
        userService.regist(user);
        req.setAttribute("msg", "注册成功，请邮件激活后在登录");
        System.out.println("注册成功" + req.getParameterMap().toString());

        return "/jsp/login.jsp";

    }

    public String active(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String code = req.getParameter("code");
        UserServiceImpl userService = new UserServiceImpl();
        userService.activeUser(code);
        req.setAttribute("msg", "激活成功，请登录");

        return "/jsp/login.jsp";

    }

    public String login(HttpServletRequest req, HttpServletResponse res) throws Exception {

        User user = MyBeanUtils.populate(User.class, req.getParameterMap());

        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.login(user);
        if (login == null) {
            req.setAttribute("msg", "账号或密码错误请重试");
            return "/jsp/login.jsp";
        } else {

            if ("1".equals(req.getParameter("rememberme"))) {
                Cookie cookie = new Cookie("remembermeCookie", login.getUsername());
                cookie.setMaxAge(60 * 60 * 24 * 7);
                cookie.setPath("/");
                res.addCookie(cookie);

            } else {
                Cookie cookie = new Cookie("remembermeCookie", "");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }


            if ("1".equals(req.getParameter("autoLogin"))) {
                Cookie cookie = new Cookie("autoLoginCookie", login.getUsername() + "@" + login.getPassword());
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24);
                res.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("autoLoginCookie", "");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }


            if (login.getState() == 0) {
                req.setAttribute("msg", "账号未激活，请邮件激活后在登录");
                return "/jsp/login.jsp";
            } else {
                req.getSession().setAttribute("loginUser", login);
                res.sendRedirect(req.getContextPath() + "/");
                return null;
            }
        }

    }

    public String logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Cookie cookie = new Cookie("autoLoginCookie", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        req.removeAttribute("loginUser");
        res.sendRedirect(req.getContextPath() + "/UserServlet?method=loginUI");
        return null;
    }
}
