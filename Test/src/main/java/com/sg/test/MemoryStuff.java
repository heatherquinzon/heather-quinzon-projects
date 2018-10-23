/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.test;

/**
 *
 * @author heath
 */
public class MemoryStuff {
    public static void main(String[] args){
        
        int i=10;
        
        System.out.println("Before Method");
        System.out.println(i);
        
        System.out.println("After Method");
        changeVariable(i);
        System.out.println(i);
    }
    
    public static void changeVariable(int v){
        v = 5;
    }

}
