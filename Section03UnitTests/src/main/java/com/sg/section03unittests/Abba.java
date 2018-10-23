/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author heath
 */
public class Abba {

    public static String abba(String a, String b) {

        //String repeated = new String(new char[n]).replace("\0", str);

        String repeated = new String(a + b + a + b);
        
        return repeated;
    }

    /*public static void main(String[] args) {
        
        System.out.println(abba("Name", " "));
        
    }*/
    
}
