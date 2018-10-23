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
public class StringTimes {

    public static String stringTimes(String str, int n) {
        //str = "Hi";
        
        String repeated = new String(new char[n]).replace("\0", str);
                
        return repeated;
        
    }
    
    /*public static void main(String[] args) {
        
        System.out.println(stringTimes("abc",3));
        
    }*/

}
