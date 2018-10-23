/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flowcontrol;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class GuessMe {
    public static void main(String[] args){
        
        int correct = 3;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("***Let's play a guessing game!***\n");
        System.out.print("\nGuess my number! \nHint, it's a number between 0-10: ");
        int guess = Integer.parseInt(sc.nextLine());
        
        if (guess == 3){
            System.out.println("\nWow, nice guess! That was it!");
        } else if (guess < 3){
            System.out.println("\nHa, nice try - too low! I chose 3");
        } else {
            System.out.println("\nToo bad, way too high. I chose 3");
        }
        
    }
    
}
