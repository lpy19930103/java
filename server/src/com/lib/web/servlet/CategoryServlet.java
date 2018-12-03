package com.lib.web.servlet;

import com.lib.web.base.BaseServlet;
import com.lib.web.domain.Category;
import com.lib.web.service.impl.CategoryServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CategoryServlet extends BaseServlet {
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=UTF=8");
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        List<Category> all = categoryService.findAll();
        String jsonStr = JSONArray.fromObject(all).toString();
        response.getWriter().print(jsonStr);
        System.out.println(jsonStr);
        return null;

    }
}
