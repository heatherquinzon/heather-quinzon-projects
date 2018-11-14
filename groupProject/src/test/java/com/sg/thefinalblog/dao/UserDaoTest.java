/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Post;
import com.sg.thefinalblog.dto.Role;
import com.sg.thefinalblog.dto.User;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author abdiriman
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UserDaoTest {

    @Inject
    UserDao users;
    
    @Inject
    PostDao posts;

    @Inject
    RoleDao roles;

    @Inject
    JdbcTemplate jdbc;

    public UserDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private static final String INSERT_ADMIN_USER
            = "INSERT INTO users (id, username, pass, enabled) "
            + "VALUES(1, 'admin', 'pass', 1)";

    @Before
    public void setUp() {

        List<Post> ps = posts.getAllPosts();
        for(Post p : ps) {
            posts.deletePost(p.getId());
        }
        
        List<User> userList = users.getAllUsers();
        for (User u : userList) {
            users.removeUser(u.getId());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllRemoveUser() {
        Role role = roles.getRoleById(1);

        Set<Role> r = new HashSet();
        r.add(role);

        User u = new User();
        u.setUsername("user");
        u.setPassword("pass");
        u.setEnabled(true);
        u.setRoles(r);
        users.addUser(u);

        User fromDao = users.getUserById(u.getId());

        assertEquals(fromDao, u);
        jdbc.update(INSERT_ADMIN_USER);
        users.removeUser(u.getId());

        assertNull(users.getUserById(u.getId()));

    }

    @Test
    public void testUpdateUser() {
        Role role = roles.getRoleById(1);

        Set<Role> r = new HashSet();
        r.add(role);

        User user = new User();
        user.setUsername("Abdi");
        user.setPassword("Foreverr");
        user.setEnabled(true);
        user.setRoles(r);
        users.addUser(user);

        user.setUsername("Gucci");
        users.updateUser(user);

        User fromDao = users.getUserById(user.getId());

        assertEquals(fromDao, user);

    }

    @Test
    public void testGetAllUsers() {
        Role role = roles.getRoleById(1);
        Set<Role> r = new HashSet();
        r.add(role);

        User user = new User();
        user.setUsername("Abdi");
        user.setPassword("Foreverr");
        user.setEnabled(true);
        user.setRoles(r);
        users.addUser(user);

        Role role2 = roles.getRoleById(2);
        Set<Role> r2 = new HashSet();
        r2.add(role);

        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword("pass");
        user2.setEnabled(true);
        user2.setRoles(r2);
        users.addUser(user2);

        List<User> uList = users.getAllUsers();

        assertEquals(uList.size(), 2);

    }

    @Test
    public void testGetUserByUsername() {
    }

}
