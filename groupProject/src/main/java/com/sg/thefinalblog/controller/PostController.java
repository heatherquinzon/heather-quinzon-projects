/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.controller;

import com.sg.thefinalblog.dao.CategoryDao;
import com.sg.thefinalblog.dao.PostDao;
import com.sg.thefinalblog.dao.TagDao;
import com.sg.thefinalblog.dao.UserDao;
import com.sg.thefinalblog.dto.Category;
import com.sg.thefinalblog.dto.Post;
import com.sg.thefinalblog.dto.Tag;
import com.sg.thefinalblog.dto.User;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Charlie
 */
@Controller
public class PostController {

    private PostDao pDao;

    @Inject
    public void PostController(PostDao pDao) {
        this.pDao = pDao;
    }

    @Inject
    UserDao uDao;

    @Inject
    CategoryDao cDao;

    @Inject
    TagDao tDao;

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String displayPostPage(Model model) {
        List<Post> postList = pDao.getAllPosts();
        model.addAttribute("postList", postList);

        List<Category> catList = cDao.getAllCategories();
        model.addAttribute("catList", catList);

        return "post";
    }

    @GetMapping("/approvePosts")
    public String displayPostsThatNeedApproval(Model model) {
        List<Post> postList = pDao.getAllPosts();
        model.addAttribute("postList", postList);

        return "approvePosts";
    }

    @RequestMapping(value = "/approveThisPost", method = RequestMethod.POST)
    public String updatePostApproval(Integer postId) {

        Post post = pDao.getPostById(postId);
        post.setState(1);

        pDao.updatePost(post);

        return "redirect:home";
    }

    @RequestMapping(value = "/createPost", method = RequestMethod.POST)
    public String createPost(HttpServletRequest request, Principal p) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Post post = new Post();
        post.setDate(LocalDate.now());
        post.setContent(request.getParameter("content"));
        if (request.getParameter("category") != null && !request.getParameter("category").isEmpty()) {
            post.setCategory(cDao.getCategoryById(Integer.parseInt(request.getParameter("category"))));
        }

        if (request.getParameter("referencedpost") != null) {
            post.setReferencedPost(pDao.getPostById(Integer.parseInt(request.getParameter("referencedpost"))));
        }
        post.setState(2);
        post.setUser(uDao.getUserByUsername(p.getName()));
        post.setTitle(request.getParameter("title"));
        if (request.getParameterValues("tags") != null) {
            String[] tagsList = request.getParameterValues("tags");
            List<Tag> postTags = new ArrayList<>();
            List<Tag> allTags = tDao.getAllTags();
            boolean isNew = true;
            for (String tagStr : tagsList) {
                for (Tag t : allTags) {
                    if (tagStr.equalsIgnoreCase(t.getName())) {
                        isNew = false;
                        postTags.add(t);
                    }
                }
                if (isNew == true) {
                    Tag t = new Tag();
                    t.setName(tagStr);
                    t = tDao.addTag(t);
                    postTags.add(t);
                }
            }
            post.setTags(postTags);
        }

        pDao.addPost(post);

        return "redirect:approvePosts";
    }

    @RequestMapping(value = "/postDetails", method = RequestMethod.GET)
    public String DisplayPostDetails(HttpServletRequest request, Model model) {
        String postIdParameter = request.getParameter("postId");

        int postId = Integer.parseInt(postIdParameter);

        Post post = pDao.getPostById(postId);

        model.addAttribute("postId", postId);

        return "postDetails";
    }

    @RequestMapping(value = "deletePost", method = RequestMethod.GET)
    public String deletePost(HttpServletRequest request) {
        String postIdParameter = request.getParameter("id");

        int postId = Integer.parseInt(postIdParameter);

        pDao.deletePost(postId);

        return "redirect:home";
    }

    @RequestMapping(value = "editPost", method = RequestMethod.GET)
    public String displayEditPostForm(HttpServletRequest request, Model model) {
        String postIdParameter = request.getParameter("id");

        int postId = Integer.parseInt(postIdParameter);
        Post post = pDao.getPostById(postId);
        List<Category> catList = cDao.getAllCategories();
        model.addAttribute("catList", catList);
        model.addAttribute("post", post);

        return "editPost";
    }

    @RequestMapping(value = "updatePost", method = RequestMethod.POST)
    public String editPost(@Valid @ModelAttribute("post") Post post, BindingResult result, HttpServletRequest request) {

        String userIdParameter = request.getParameter("userId");
        int userId = Integer.parseInt(userIdParameter);
        
        User user = uDao.getUserById(userId);
        post.setUser(user);
        
         if (request.getParameterValues("tags") != null) {
            String[] tagsList = request.getParameterValues("tags");
            List<Tag> postTags = new ArrayList<>();
            List<Tag> allTags = tDao.getAllTags();
            boolean isNew = true;
            for (String tagStr : tagsList) {
                for (Tag t : allTags) {
                    if (tagStr.equalsIgnoreCase(t.getName())) {
                        isNew = false;
                        postTags.add(t);
                    }
                }
                if (isNew == true) {
                    Tag t = new Tag();
                    t.setName(tagStr);
                    t = tDao.addTag(t);
                    postTags.add(t);
                }
            }
            post.setTags(postTags);
        }
        
        pDao.updatePost(post);

        return "redirect:approvePosts";
    }
}
