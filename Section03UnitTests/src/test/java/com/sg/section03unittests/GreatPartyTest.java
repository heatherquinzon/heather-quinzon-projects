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
public class GreatPartyTest {

    GreatParty party = new GreatParty();

    public GreatPartyTest() {
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
     * Test of greatParty method, of class GreatParty.
     */
    /*@Test
    public void testGreatParty() {
        fail("The test case is a prototype.");
    }*/

    @Test
    public void test30false() {
        assertFalse(party.greatParty(30, false));
    }
    
    @Test
    public void test50false() {
        assertTrue(party.greatParty(50, false));
    }
    
    @Test
    public void test70true() {
        assertTrue(party.greatParty(70, true));
    }
   
    @Test
    public void test39true() {
        assertFalse(party.greatParty(30, true));
    }
    
    @Test
    public void test39false() {
        assertFalse(party.greatParty(39, false));
    }
    
    @Test
    public void test60true() {
        assertTrue(party.greatParty(60, true));
    }
    
    @Test
    public void test60false() {
        assertTrue(party.greatParty(60, false));
    }
     
    @Test
    public void test61true() {
        assertTrue(party.greatParty(61, true));
    }
    
    @Test
    public void test61false() {
        assertFalse(party.greatParty(61, false));
    }
    
    
}


