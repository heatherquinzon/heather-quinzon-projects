/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Role;
import java.util.List;
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
 * @author heath
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class RoleDaoDbImplTest {

    @Inject
    RoleDao roles;

    public RoleDaoDbImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAddRemoveRole() {
        Role r = new Role();
        r.setRole("Creator");
        roles.addRole(r);

        Role fromDao = roles.getRoleById(r.getId());

        assertEquals(fromDao, r);

        roles.removeRole(r.getId());

        assertNull(roles.getRoleById(r.getId()));
    }

    @Test
    public void updateRole() {
        Role r = new Role();
        r.setRole("Creator");
        roles.addRole(r);

        r.setRole("content creator");
        roles.updateRole(r);
        
        Role fromDao = roles.getRoleById(r.getId());

        assertEquals(fromDao, r);
        
        roles.removeRole(r.getId());

        assertNull(roles.getRoleById(r.getId()));
    }

    @Test
    public void getAllRoles() {
        List<Role> rList = roles.getAllRoles();
        
        assertEquals(rList.size(), 2);
        
    }
    
}
