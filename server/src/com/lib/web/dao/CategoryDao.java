package com.lib.web.dao;

import com.lib.web.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> findAll() throws SQLException;
}
