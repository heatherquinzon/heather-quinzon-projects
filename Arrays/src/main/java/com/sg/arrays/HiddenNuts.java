/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrays;

import java.util.Random;

/**
 *
 * @author heath
 */
public class HiddenNuts {
    public static void main(String[] args) {
        
        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        //hidingSpots[89] = "Nut";
        //this code says the hidingSpots[of randomInt(length of hidingSpots)]
        // equals the string "Nut";
        
        System.out.println("The nut has been hidden ...");
        
        for (int i=0; i < hidingSpots.length; i++){
            
            if(hidingSpots[i] == "Nut"){
            System.out.println("Found it! It's in spot# " + i);
            }
        }
        
        
    }
}
