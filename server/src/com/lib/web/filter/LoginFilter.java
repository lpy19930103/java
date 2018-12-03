package com.lib.web.filter;


import com.lib.web.domain.User;
import com.lib.web.service.impl.UserServiceImpl;
import com.lib.web.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,  ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getServletPath().equals("/UserServlet")) {
            String method = request.getParameter("method");

            if ("loginUI".equals(method)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            filterChain.doFilter(request, response);
            return;
        }

        Cookie autoLoginCookie = CookieUtils.getCookie(request.getCookies(), "autoLoginCookie");

        if (autoLoginCookie == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String[] split = autoLoginCookie.getValue().split("@");
        String userName = split[0];
        String password = split[1];
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        try {
            User login = new UserServiceImpl().login(user);
            if (login == null){
                filterChain.doFilter(request, response);
                return;
            }
            request.getSession().setAttribute("loginUser",login);
            filterChain.doFilter(request, response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}
