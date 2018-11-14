/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Category;
import com.sg.thefinalblog.dto.Post;
import com.sg.thefinalblog.dto.Role;
import com.sg.thefinalblog.dto.Tag;
import com.sg.thefinalblog.dto.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author abdiriman
 */
@RunWith(SpringJUnit4ClassRunner.class) //Actually loads up the beans
@ContextConfiguration(locations = "classpath:test-applicationContext.xml") //Says which beans to create

public class PostDaoTest {

    @Inject
    PostDao posts;

    @Inject
    TagDao tags;

    @Inject
    UserDao users;

    @Inject
    CategoryDao categories;

    @Inject
    RoleDao roles;

    public PostDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Post> postList = posts.getAllPosts();
        for (Post p : postList) {
            posts.deletePost(p.getId());
        }

        List<Tag> tagList = tags.getAllTags();
        for (Tag t : tagList) {
            tags.deleteTag(t.getId());
        }

        List<User> userList = users.getAllUsers();
        for (User u : userList) {
            users.removeUser(u.getId());
        }

        List<Category> categoryList = categories.getAllCategories();
        for (Category c : categoryList) {
            categories.deleteCategory(c.getId());
        }
    }

    @After

    public void tearDown() {
    }

    @Test
    public void getAddRemovePost() {
        //ADD TAGS
        Tag tag = new Tag();
        tag.setName("#news");
        tag = tags.addTag(tag);
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        //ADD ROLE
        Role role = roles.getRoleById(1);
        Set<Role> r = new HashSet();
        r.add(role);

        User u = new User();
        u.setUsername("user");
        u.setPassword("pass");
        u.setEnabled(true);
        u.setRoles(r);
        u = users.addUser(u);

        //ADD CATEGORY
        Category c = new Category();
        c.setName("BlogPost");
        c = categories.addCategory(c);

        //ADD FIRST POST (NULL REFERENCING ID)
        LocalDate date = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);
        Post post = new Post();
        post.setContent("THE BLOG POST");
        post.setTitle("News");
        post.setDate(date);
        post.setState(2);
        post.setUser(u);
        post.setTags(tagList);
        post.setCategory(c);
        post = posts.addPost(post);

        //ADD REPLY POST
        Post post2 = new Post();
        post2.setContent("REPLY REPLY REPLY");
        post2.setTitle("News");
        post2.setDate(date);
        post2.setUser(u);
        post2.setState(2);
        post2.setTags(tagList);
        post2.setCategory(c);
        post2.setReferencedPost(post);
        post2 = posts.addPost(post2);

        Post fromDao = posts.getPostById(post.getId());

        assertEquals(fromDao, post);

        Post fromDao2 = posts.getPostById(post2.getId());

        assertEquals(fromDao2, post2);

        posts.deletePost(post.getId());

        fromDao = posts.getPostById(post.getId());
        assertNull(fromDao);
        fromDao2 = posts.getPostById(post2.getId());
        assertNull(fromDao2);
    }

    @Test
    public void testUpdatePost() {
        //ADD TAGS
        Tag tag = new Tag();
        tag.setName("#news");
        tag = tags.addTag(tag);
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        //ADD ROLE
        Role role = roles.getRoleById(1);
        Set<Role> r = new HashSet();
        r.add(role);

        User u = new User();
        u.setUsername("user");
        u.setPassword("pass");
        u.setEnabled(true);
        u.setRoles(r);
        u = users.addUser(u);

        //ADD CATEGORY
        Category c = new Category();
        c.setName("BlogPost");
        c = categories.addCategory(c);

        //ADD FIRST POST (NULL REFERENCING ID)
        LocalDate date = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);
        Post post = new Post();
        post.setContent("THE BLOG POST");
        post.setTitle("News");
        post.setDate(date);
        post.setUser(u);
        post.setTags(tagList);
        post.setCategory(c);
        post = posts.addPost(post);

        //ADD REPLY POST
        Post post2 = new Post();
        post2.setContent("REPLY REPLY REPLY");
        post2.setTitle("News");
        post2.setDate(date);
        post2.setUser(u);
        post2.setTags(tagList);
        post2.setCategory(c);
        post2.setReferencedPost(post);
        post2 = posts.addPost(post2);

        Post fromDao = posts.getPostById(post.getId());

        assertEquals(fromDao, post);

        Post fromDao2 = posts.getPostById(post2.getId());

        assertEquals(fromDao2, post2);

        post.setContent("THEEEE BLOG POST");
        u.setUsername("USER");
        users.updateUser(u);
        c.setName("BLOGGGY");
        categories.updateCategory(c);
        tag.setName("#TAGSBABY");
        tags.updateTag(tag);
        posts.updatePost(post);

        fromDao = posts.getPostById(post.getId());

        assertEquals(fromDao, post);

        post2.setContent("THEEEE BLOG POST 2");
        posts.updatePost(post2);
        fromDao2 = posts.getPostById(post2.getId());
        assertEquals(fromDao2, post2);
    }

    @Test
    public void testGetAllPosts() {
        //ADD TAGS
        Tag tag = new Tag();
        tag.setName("#news");
        tag = tags.addTag(tag);
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        //ADD ROLE
        Role role = roles.getRoleById(1);
        Set<Role> r = new HashSet();
        r.add(role);

        User u = new User();
        u.setUsername("user");
        u.setPassword("pass");
        u.setEnabled(true);
        u.setRoles(r);
        u = users.addUser(u);

        //ADD CATEGORY
        Category c = new Category();
        c.setName("BlogPost");
        c = categories.addCategory(c);

        //ADD FIRST POST (NULL REFERENCING ID)
        LocalDate date = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);
        Post post = new Post();
        post.setContent("THE BLOG POST");
        post.setTitle("News");
        post.setDate(date);
        post.setUser(u);
        post.setTags(tagList);
        post.setCategory(c);
        post = posts.addPost(post);

        //ADD REPLY POST
        Post post2 = new Post();
        post2.setContent("ANOTHER BLOG POST IN THE CATEGORY");
        post2.setTitle("News");
        post2.setDate(date);
        post2.setUser(u);
        post2.setTags(tagList);
        post2.setCategory(c);
        post2 = posts.addPost(post2);
        
        assertEquals(posts.getAllPosts().size(), 2);
    }
    
    @Test
    public void getAllPostsByCategoryId(){
                //ADD TAGS
        Tag tag = new Tag();
        tag.setName("#news");
        tag = tags.addTag(tag);
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        //ADD ROLE
        Role role = roles.getRoleById(1);
        Set<Role> r = new HashSet();
        r.add(role);

        User u = new User();
        u.setUsername("user");
        u.setPassword("pass");
        u.setEnabled(true);
        u.setRoles(r);
        u = users.addUser(u);

        //ADD CATEGORY
        Category c = new Category();
        c.setName("BlogPost");
        c = categories.addCategory(c);

        //ADD FIRST POST (NULL REFERENCING ID)
        LocalDate date = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);
        Post post = new Post();
        post.setContent("THE BLOG POST");
        post.setTitle("News");
        post.setDate(date);
        post.setUser(u);
        post.setTags(tagList);
        post.setCategory(c);
        post = posts.addPost(post);

        //ADD REPLY POST
        Post post2 = new Post();
        post2.setContent("ANOTHER BLOG POST IN THE CATEGORY");
        post2.setTitle("News");
        post2.setDate(date);
        post2.setUser(u);
        post2.setTags(tagList);
        post2.setCategory(c);
        post2 = posts.addPost(post2);
        
        assertEquals(posts.getAllPostsByCategoryId(c.getId()).size(), 2);
    }

    @Test
    public void getAllPostsByTagId() {
        //ADD TAGS
        Tag tag = new Tag();
        tag.setName("#news");
        tag = tags.addTag(tag);
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);

        //ADD ROLE
        Role role = roles.getRoleById(1);
        Set<Role> r = new HashSet();
        r.add(role);

        User u = new User();
        u.setUsername("user");
        u.setPassword("pass");
        u.setEnabled(true);
        u.setRoles(r);
        u = users.addUser(u);

        //ADD CATEGORY
        Category c = new Category();
        c.setName("BlogPost");
        c = categories.addCategory(c);

        //ADD FIRST POST (NULL REFERENCING ID)
        LocalDate date = LocalDate.parse("2018-10-03",
                DateTimeFormatter.ISO_LOCAL_DATE);
        Post post = new Post();
        post.setContent("THE BLOG POST");
        post.setTitle("News");
        post.setDate(date);
        post.setUser(u);
        post.setTags(tagList);
        post.setCategory(c);
        post = posts.addPost(post);

        //ADD REPLY POST
        Post post2 = new Post();
        post2.setContent("ANOTHER BLOG POST IN THE TAG");
        post2.setTitle("News");
        post2.setDate(date);
        post2.setUser(u);
        post2.setTags(tagList);
        post2.setCategory(c);
        post2 = posts.addPost(post2);
        
        assertEquals(posts.getAllPostsByTagId(tag.getId()).size(), 2);
    }
}
