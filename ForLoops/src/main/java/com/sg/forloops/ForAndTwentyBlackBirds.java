/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.forloops;

/**
 *
 * @author heath
 */
public class ForAndTwentyBlackBirds {
      public static void main(String[] args) {
        int birdsInPie = 0;
        for (int i = 0; i < 24; i++) {
            System.out.println("Blackbird #" + (i + 1) + " goes into the pie!");
            //when printing out i, it prints index, if you want to start at 1
            //you have to printout (i + 1)
            birdsInPie++;
        }

        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
        
    }
    
}
