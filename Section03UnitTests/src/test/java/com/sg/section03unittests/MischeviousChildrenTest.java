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
public class MischeviousChildrenTest {
    
    private MischeviousChildren mc = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
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
     * Test of areWeInTrouble method, of class MischeviousChildren.
     */
    @Test
    public void testAreWeInTrouble1() {
        Boolean test = mc.areWeInTrouble(true, true);
        assertTrue(test);
    }
    
    @Test
    public void testAreWeInTrouble2() {
        Boolean test = mc.areWeInTrouble(false, false);
        assertTrue(test);
    }
   
    @Test
    public void testAreWeInTrouble3() {
        Boolean test = mc.areWeInTrouble(true, false);
        assertFalse(test);
    }
    
    @Test
    public void testAreWeInTrouble4() {
        Boolean test = mc.areWeInTrouble(false, true);
        assertFalse(test);
    }
}
