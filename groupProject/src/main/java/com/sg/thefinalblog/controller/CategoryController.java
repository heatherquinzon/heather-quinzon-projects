/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.controller;

import com.sg.thefinalblog.dao.CategoryDao;
import com.sg.thefinalblog.dto.Category;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author abdiriman
 */
@Controller
public class CategoryController {

    CategoryDao dao;

    @Inject
    public CategoryController(CategoryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayCategorysPage", method = RequestMethod.GET)
    public String displayCategoryPage(Model model) {
        List<Category> categoryList = dao.getAllCategories();

        model.addAttribute("categoryList", categoryList);
        
        return "categorys";
    }   
    
    @RequestMapping(value = "/createCategory", method = RequestMethod.POST)
    public String createCategory(HttpServletRequest request) {

      Category category = new Category();
      category.setName(request.getParameter("name"));
      
      dao.addCategory(category);
        
      return "redirect:displayCategorysPage";
    }
    
    @RequestMapping(value="/categoryDetails", method= RequestMethod.GET)
    public String DisplayCategoryDetails(HttpServletRequest request, Model model) {
        String categoryIdParameter = request.getParameter("categoryId");

        int categoryId = Integer.parseInt(categoryIdParameter);

        Category category = dao.getCategoryById(categoryId);

        model.addAttribute("categoryId", categoryId);


        return "categoryDetails";
    }
    
    @RequestMapping(value="deleteCategory", method=RequestMethod.GET)
    public String deleteCategory (HttpServletRequest request) {
        String categoryIdParameter = request.getParameter("categoryId");

        int categoryId = Integer.parseInt(categoryIdParameter);

        dao.deleteCategory(categoryId);


        return "redirect:displayCategorysPage";
    }
    
    @RequestMapping(value="displayEditCategoryForm", method=RequestMethod.GET)
    public String displayEditCategoryForm (HttpServletRequest request, Model model) {
        String categoryIdParameter = request.getParameter("categoryId");

        int categoryId= Integer.parseInt(categoryIdParameter);
        Category category = dao.getCategoryById(categoryId);
        model.addAttribute("category", category);

        return "editCategoryForm";
    }


    @RequestMapping(value="editCategory", method= RequestMethod.POST)
    public String editCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {

        if(result.hasErrors()) {
            return "editCategoryForm";
        }

        dao.updateCategory(category);

        return "redirect:displayCategorysPage";
    }
}
