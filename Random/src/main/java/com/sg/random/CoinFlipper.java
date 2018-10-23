package com.sg.random;

import java.util.Random;

/**
 *
 * @author heath
 */
public class CoinFlipper {
    public static void main(String[] args){
        
        Random r = new Random();
        
        Boolean coin = r.nextBoolean();
        
        System.out.println("Ready, Set, Flip...!");
        
        if (coin == true){
            System.out.println("You got Heads!");
        } else {
            System.out.println("You got Tails!");
        }
    }
    
}
