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
public class GuessMeFinally {
    public static void main(String[] args){
        
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        
        int myNum = r.nextInt(100 - (-100) + 1) + (-100);
        
        /*for(int i=0; i<100; i++){
           int myNum = r.nextInt(100 - (-100) + 1) + (-100); 
            System.out.println(myNum);
        }*/
        
        System.out.println("Okay, let's play a guessing game!");
        System.out.println("I've chosen a number between -100 and 100.");
        System.out.println("Betcha can't guess it!");
        
        System.out.print("Your guess: ");
        int guess = sc.nextInt();
        
        if (guess == myNum){
            System.out.println("Wow, nice guess! You got it on"
                    + " your first try!");
        }
         
        while (guess != myNum){
                        
            if (guess < myNum){
                System.out.println("Nice try - too low! Try again.");
            } else if (guess > myNum){
                System.out.println("Oops - too high! Try again.");
            }
            
            System.out.print("Your guess: ");
            guess = sc.nextInt();
        } 
          
        System.out.println("Finally, it's about time you got it!");
    }
    
}
