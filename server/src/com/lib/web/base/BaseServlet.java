package com.lib.web.base;

import com.lib.web.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        if (StringUtils.isEmpty(methodName)) {
            methodName = "execute";
        }
        try {
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            if (method != null) {
                String jspPath = (String) method.invoke(this, req, resp);

                if (jspPath != null) {
                    req.getRequestDispatcher(jspPath).forward(req, resp);

                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        return null;
    }
}
