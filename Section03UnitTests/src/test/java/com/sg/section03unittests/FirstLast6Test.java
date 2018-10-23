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
public class FirstLast6Test {
    
    private FirstLast6 f = new FirstLast6();
    
    public FirstLast6Test() {
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
     * Test of firstLast6 method, of class FirstLast6.
     */
    @Test
    public void testFirstLast6First() {
        int[] arr = {6,1,2};
        assertTrue(f.firstLast6(arr));
    }
    
    @Test
    public void testFirstLast6Last() {
        int[] arr = {1,3,4,7,6};
        assertTrue(f.firstLast6(arr));
    }
    
    @Test
    public void testFirstLast6Mid() {
        int[] arr = {1,6,2,4,5,8};
        assertFalse(f.firstLast6(arr));
    }
    
}
