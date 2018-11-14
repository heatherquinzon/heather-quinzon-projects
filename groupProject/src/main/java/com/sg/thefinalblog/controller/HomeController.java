/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.controller;

/**
 *
 * @author Charlie
 */
import com.sg.thefinalblog.dao.CategoryDao;
import com.sg.thefinalblog.dao.PostDao;
import com.sg.thefinalblog.dao.TagDao;
import com.sg.thefinalblog.dto.Category;
import com.sg.thefinalblog.dto.Post;
import com.sg.thefinalblog.dto.Tag;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    
    @Inject
    PostDao pDao;
    
    @Inject
    CategoryDao cDao;
    
    @Inject
    TagDao tDao;

    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
    public String displayHomePage(HttpServletRequest request, Model model) {
        List<Post> postList = pDao.getAllPosts();
        model.addAttribute("postList", postList);
        
        List<Category> catList = cDao.getAllCategories();
        model.addAttribute("catList", catList);
                
        return "home";
    }
    
    @GetMapping("/displayCatPosts")
    public String displayCatPosts(HttpServletRequest request, Model model) {
        String catIdParamater = request.getParameter("id");
        int catId = Integer.parseInt(catIdParamater);
        
        Category cat = cDao.getCategoryById(catId);
        model.addAttribute("cat", cat);
        
        List<Post> postList = pDao.getAllPostsByCategoryId(catId);
        model.addAttribute("postList", postList);
        
        return "categoryPosts";
    }
    
    @GetMapping("/displayTagPosts")
    public String displayTagPosts(HttpServletRequest request, Model model) {
        String tagIdParameter = request.getParameter("id");
        int tagId = Integer.parseInt(tagIdParameter);
        
        Tag tag = tDao.getTagById(tagId);
        model.addAttribute("tag", tag);
        
        List<Post> postList = pDao.getAllPostsByTagId(tagId);
        model.addAttribute("postList", postList);
        
        return "tagPosts";
    }
    
}
