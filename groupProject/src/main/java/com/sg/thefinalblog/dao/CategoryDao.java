/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Category;
import java.util.List;

/**
 *
 * @author abdiriman
 */
public interface CategoryDao {
    public Category getCategoryById(int id);
    
    public Category addCategory(Category category);
   
    public List<Category>getAllCategories();
    
    public void updateCategory(Category category);
    
    public void deleteCategory(int id);
}   
