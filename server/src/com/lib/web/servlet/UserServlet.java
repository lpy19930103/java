package com.lib.web.servlet;

import com.lib.web.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("findAll");

    }
}
