package com.lib.web.base;

import com.lib.web.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        String methodName = req.getParameter("method");
        if (StringUtils.isEmpty(methodName)) {
            methodName = "execute";
        }
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            String jspPath = (String) method.invoke(this, req, resp);

            if (StringUtils.notEmpty(jspPath)) {
                req.getRequestDispatcher(jspPath).forward(req, resp);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return null;
    }
}
