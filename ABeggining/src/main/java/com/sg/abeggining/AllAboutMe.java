/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.abeggining;

/**
 *
 * @author heath
 */
public class AllAboutMe {
    public static void main(String[] args){
        
        String name = "Heather Quinzon";
        String favFood = "sushi";
        int pets = 2;
        Boolean gnocchi = false;
        int whistleAge = 4;
        
        System.out.println("I am " + name);
        System.out.println("I have " + pets + " pets.");
        System.out.println("My favorite food is " + favFood);
        
        if(gnocchi == true){
            System.out.println("I have eaten gnocchi before.");
        }else{
            System.out.println("I have never had gnocchi.");
        }
        
        System.out.println("I was " + whistleAge + " when I learned to whistle.");
        
        
    }
    
}
