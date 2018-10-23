/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author heath
 */
public class DVDdaoTest {
    
    private DVDdao dao = new DVDdaoImpl();
        
    public DVDdaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<DVD> dvdList = dao.getAllDVD();
        for(DVD dvd : dvdList){
            dao.removeDVD(dvd.getTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllDVD method, of class DVDdao.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllDVD() throws Exception {
        DVD movie1 = new DVD();
        movie1.setTitle("Jaws");
        movie1.setReleaseDate("06/20/1975");
        movie1.setMpaaRating("R");
        movie1.setDirectorName("Spielberg");
        movie1.setStudio("Universal");
        movie1.setExtraNotes("Never seen it");
        dao.addDVD(movie1.getTitle(), movie1);
        
        
        DVD movie2 = new DVD();
        movie2.setTitle("Howls Moving Caster");
        movie2.setReleaseDate("06/10/2004");
        movie2.setMpaaRating("PG");
        movie2.setDirectorName("Miyazaki");
        movie2.setStudio("Ghibli");
        movie2.setExtraNotes("Love it");
        dao.addDVD(movie2.getTitle(), movie2);
        
        assertEquals(2, dao.getAllDVD().size());
        
        
    }

    /**
     * Test of addDVD method, of class DVDdao.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddGetDVD() throws Exception {
        DVD movie = new DVD("Howls Moving Castle");
        movie.setTitle("Howls Moving Caster");
        movie.setReleaseDate("06/10/2004");
        movie.setMpaaRating("PG");
        movie.setDirectorName("Miyazaki");
        movie.setStudio("Ghibli");
        movie.setExtraNotes("Love it");
        dao.addDVD(movie.getTitle(), movie);
        
        DVD fromDao = dao.addDVD(movie.getTitle(), movie);
        
        assertEquals(movie, fromDao);
        
    }
    
    /**
     * Test of removeDVD method, of class DVDdao.
     */
    @Test
    public void testRemoveDVD() throws Exception {
        DVD movie1 = new DVD();
        movie1.setTitle("Jaws");
        movie1.setReleaseDate("06/20/1975");
        movie1.setMpaaRating("R");
        movie1.setDirectorName("Spielberg");
        movie1.setStudio("Universal");
        movie1.setExtraNotes("Never seen it");
        dao.addDVD(movie1.getTitle(), movie1);
        
        DVD movie2 = new DVD();
        movie2.setTitle("Howls Moving Caster");
        movie2.setReleaseDate("06/10/2004");
        movie2.setMpaaRating("PG");
        movie2.setDirectorName("Miyazaki");
        movie2.setStudio("Ghibli");
        movie2.setExtraNotes("Love it");
        dao.addDVD(movie2.getTitle(), movie2);
    
        dao.removeDVD(movie1.getTitle());
        assertEquals(1, dao.getAllDVD().size());
        assertNull(dao.getDVD(movie1.getTitle()));
        
        dao.removeDVD(movie2.getTitle());
        assertEquals(0, dao.getAllDVD().size());
        assertNull(dao.getDVD(movie2.getTitle()));
        
    }

}
