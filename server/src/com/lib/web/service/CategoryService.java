package com.lib.web.service;

import com.lib.web.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    List<Category> findAll() throws SQLException;
}
