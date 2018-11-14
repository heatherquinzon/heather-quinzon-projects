/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.thefinalblog.dao;

import com.sg.thefinalblog.dto.Post;
import com.sg.thefinalblog.dto.Tag;
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

public class TagDaoTest {

    @Inject
    TagDao tags;

    public TagDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Tag> tagList = tags.getAllTags();
        for (Tag t : tagList) {
            tags.deleteTag(t.getId());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllRemoveTag(){
        Tag t = new Tag();
        t.setName("#news");
        tags.addTag(t);
        
        Tag fromDao = tags.getTagById(t.getId());
        assertEquals(fromDao, t);
        
        tags.deleteTag(t.getId());
        assertNull(tags.getTagById(t.getId()));
        
    }

    @Test
    public void testUpdateTag() {
        Tag t = new Tag();
        t.setName("#news");
        tags.addTag(t);
        
        t.setName("#sports");
        tags.updateTag(t);
        
        Tag fromDao = tags.getTagById(t.getId());
        assertEquals(fromDao, t);

        tags.deleteTag(t.getId());
        assertNull(tags.getTagById(t.getId()));
    }

    @Test
    public void testGetAllTags() {
        Tag t = new Tag();
        t.setName("#news");
        tags.addTag(t);
        
        Tag t2 = new Tag();
        t2.setName("#sports");
        tags.addTag(t2);
        
        List<Tag> tList = tags.getAllTags();
        
        assertEquals(tList.size(), 2);
        
        tags.deleteTag(t.getId());
        tags.deleteTag(t2.getId());
    }
}
