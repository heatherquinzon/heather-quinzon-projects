/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dosandwhiles;

import java.util.Random;

/**
 *
 * @author heath
 */
public class LovesMe {
    public static void main(String[] args){
        
        System.out.println("Well, here goes nothing...");
        
        Random r = new Random();
        
        //for(int i=0; i<100; i++){
        int petals = r.nextInt(89 + 1) + 13;
        //    System.out.println(petals);
        //}         
        
        System.out.println("It LOVES me!");
        petals--; 
        
      
        while (petals>0){
                    
            
            petals--;
        }
        
        
        
    }
    
}
