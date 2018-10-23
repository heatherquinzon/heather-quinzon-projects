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
public class Stuff {
    public static void main(String[] args){
        
        String s = "Hello, how are you?";
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            switch(c){
                case 'h':
                    System.out.println("H");
                    break;
                case 'H':
                    System.out.println("H");
                    break;
                default:
                    System.out.println(c);
            }
        }
    }
    
}
