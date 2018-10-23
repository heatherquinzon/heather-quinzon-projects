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
public class AbbaTest {

    private Abba abba = new Abba();

    public AbbaTest() {
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
     * Test of abba method, of class Abba.
     */
    @Test
    public void testAbbaHiBye() {
        String expected = "HiByeHiBye";
        assertEquals(expected, abba.abba("Hi", "Bye"));
    }

    @Test
    public void testAbbaYoAlice() {
        String expected = "YoAliceYoAlice";
        assertEquals(expected, abba.abba("Yo", "Alice"));
    }

    @Test
    public void testAbbaWhatUp() {
        String expected = "WhatUpWhatUp";
        assertEquals(expected, abba.abba("What", "Up"));
    }

    @Test
    public void testAbbaNameEmpty() {
        String expected = "Name Name ";
        assertEquals(expected, abba.abba("Name", " "));
    }
}
