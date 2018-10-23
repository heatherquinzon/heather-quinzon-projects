/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heath
 */
public class CanHazTableTest {
    private CanHazTable c = new CanHazTable();
    
    public CanHazTableTest() {
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

    /**
     * Test of canHazTable method, of class CanHazTable.
     */
    @Test
    public void testCanHazTableStylish() {
        int test = c.canHazTable(5, 10);
        assertEquals(2, test);
    }
    
    @Test
    public void testCanHazTableNotStylish() {
        int test = c.canHazTable(5, 2);
        assertEquals(0, test);
    }
    
    @Test
    public void testCanHazTableMaybeStylish() {
        int test = c.canHazTable(5, 5);
        assertEquals(1, test);
    }
}
