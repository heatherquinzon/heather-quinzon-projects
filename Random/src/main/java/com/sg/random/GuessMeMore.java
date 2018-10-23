package com.sg.random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class GuessMeMore {
    public static void main(String[] args){
        
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        
        int myNum = r.nextInt(200) - 100;
        
        System.out.println("Okay, let's play a guessing game!");
        System.out.println("I've chosen a number between -100 and 100.");
        System.out.println("Betcha can't guess it!");
        
        System.out.print("Your guess: ");
        int guess = sc.nextInt();
         
        while (guess != myNum){
            
            if (guess < myNum){
                System.out.println("Nice try - too low! Try again.");
            } else if (guess > myNum){
                System.out.println("Oops - too high! Try again.");
            }
            
            System.out.print("Your guess: ");
            guess = sc.nextInt();
        } 
          
        System.out.println("Congrats! You guessed my number!");
    }
    
}
