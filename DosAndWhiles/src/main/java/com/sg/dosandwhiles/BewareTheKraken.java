/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dosandwhiles;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class BewareTheKraken {
     public static void main(String[] args) {

        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;
        String keepGoing = "y";

        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int fish = 0;
         
        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");
            
            System.out.print("Do you want to continue? (y/n): ");
            keepGoing = sc.nextLine();
            
            if(keepGoing.charAt(0) != 'y'){
               break; 
            }
            
            fish = r.nextInt(3);
            
            if (fish==0){
                System.out.println("O look a turtle!");
            } else if (fish==1){
                System.out.println("A whale!");
            } else if (fish==2){
                System.out.println("Look a seal!");
            }

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
        }
        
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
