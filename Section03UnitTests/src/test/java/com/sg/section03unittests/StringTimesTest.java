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
public class StringTimesTest {
    
    private StringTimes st = new StringTimes();
    
    public StringTimesTest() {
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
     * Test of stringTimes method, of class StringTimes.
     */
    @Test
    public void testStringTimesTwo() {
        String expectedResult = "HiHi";
        assertEquals(expectedResult, st.stringTimes("Hi", 2));
    }
    
    @Test
    public void testStringTimesThree() {
        String expectedResult = "HiHiHi";
        assertEquals(expectedResult, st.stringTimes("Hi", 3));
    }
    
    @Test
    public void testStringTimesOne() {
        String expectedResult = "Hi";
        assertEquals(expectedResult, st.stringTimes("Hi", 1));
    }
}
