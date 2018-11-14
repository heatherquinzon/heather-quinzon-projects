/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Category;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author abdiriman
 */
@RunWith(SpringJUnit4ClassRunner.class) //Actually loads up the beans
@ContextConfiguration(locations = "classpath:test-applicationContext.xml") //Says which beans to create

public class CategoryDaoTest {

    @Inject
    CategoryDao categories;

    public CategoryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Category> categoryList = categories.getAllCategories();
        for (Category c : categoryList) {
            categories.deleteCategory(c.getId());
        }
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void getAllRemoveCategory() {
        Category c = new Category();
        c.setName("News");
        categories.addCategory(c);
        
        Category fromDao = categories.getCategoryById(c.getId());
        assertEquals(fromDao, c);
        
        categories.deleteCategory(c.getId());
        assertNull(categories.getCategoryById(c.getId()));
    }
   
    @Test
    public void testUpdateCategory() {
        Category c = new Category();
        c.setName("Blog");
        categories.addCategory(c);
        
        c.setName("Genre");
        categories.updateCategory(c);

        Category fromDao = categories.getCategoryById(c.getId());
        assertEquals(fromDao, c);

        categories.deleteCategory(c.getId());
        assertNull(categories.getCategoryById(c.getId()));
        
    }

    @Test
    public void getAllCategory() {
        Category c = new Category();
        c.setName("News");
        categories.addCategory(c);
        
        Category c2 = new Category();
        c2.setName("Blog");
        categories.addCategory(c2);
        
        List<Category> cList = categories.getAllCategories();
        
        assertEquals(cList.size(), 2);
        
        categories.deleteCategory(c.getId());
        categories.deleteCategory(c2.getId());
    }

}
