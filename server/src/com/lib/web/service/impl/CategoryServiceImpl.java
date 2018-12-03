package com.lib.web.service.impl;

import com.lib.web.dao.impl.CategoryDaoImpl;
import com.lib.web.domain.Category;
import com.lib.web.service.CategoryService;

import java.sql.SQLException;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() throws SQLException {
        return new CategoryDaoImpl().findAll();
    }
}
