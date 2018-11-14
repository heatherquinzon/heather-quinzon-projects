/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author heath
 */
public class CategoryDaoDbImpl implements CategoryDao {
   
    @Inject
    JdbcTemplate jdbc;
    
    
    private static final String SELECT_CATEGORY_BY_ID
            = "SELECT * FROM category "
            + "WHERE id = ?";
    @Override
    public Category getCategoryById(int id) {
        try {
            return jdbc.queryForObject(SELECT_CATEGORY_BY_ID, new CategoryMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final String INSERT_CATEGORY = "INSERT INTO category(name) VALUES(?)";

    @Override
    public Category addCategory(Category category) {
        jdbc.update(INSERT_CATEGORY, category.getName());
        int id = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        category.setId(id);

        return category;

    }

    private static final String SELECT_CATEGORIES
            = "SELECT * FROM category";
    @Override
    public List<Category> getAllCategories() {
        return jdbc.query(SELECT_CATEGORIES, new CategoryMapper());
    }

    final String UPDATE_CATEGORY = "UPDATE category SET name = ? WHERE id = ?";
    @Override
    public void updateCategory(Category category) {
        jdbc.update(UPDATE_CATEGORY, category.getName(), category.getId());
    }
    
    private static final String INSERT_NULL_TO_POST 
            = "UPDATE post SET "
            + "categoryId = null "
            + "WHERE categoryId = ?";
    private static final String DELETE_CATEGORY = "DELETE FROM category WHERE id = ?";
    @Override
    public void deleteCategory(int id) {
        jdbc.update(INSERT_NULL_TO_POST, id);
        jdbc.update(DELETE_CATEGORY, id);
    }

    public static final class CategoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category c = new Category();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            return c;
        }
    }

}
