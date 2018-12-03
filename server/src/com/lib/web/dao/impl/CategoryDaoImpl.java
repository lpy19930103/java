package com.lib.web.dao.impl;

import com.lib.web.dao.CategoryDao;
import com.lib.web.domain.Category;
import com.lib.web.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "select * from category";
        return queryRunner.query(sql, new BeanListHandler<>(Category.class));
    }
}
