package com.lib.web.servlet;

import com.lib.web.base.BaseServlet;
import com.lib.web.domain.Category;
import com.lib.web.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class IndexServlet extends BaseServlet {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        List<Category> all = categoryService.findAll();

        req.setAttribute("allCategory", all);

        return "/jsp/index.jsp";
    }
}
