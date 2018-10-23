/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.assignments;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        
        System.out.println("Hey There!");
        System.out.println("**Let's play a game of Rock Paper Scissors!***");
        
        String repeat = "y";
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        do{
            int win=0;
            int tie=0;
            int lose=0;
            
            System.out.print("\nHow many times would you like to play? ");
            int playTime = sc.nextInt();
            if((playTime>10) || (playTime<0)){
                System.out.println("Woops! Invalid!");
                break;
            }
            
            for(int i=0; i < playTime; i++){
                
                System.out.print("\nRock(1), Paper(2), or Scissors(3)? ");
                int ans = sc.nextInt();
                
                int compChoice = r.nextInt(3)+1;
                
                if((ans==1) && (compChoice==3)){
                    System.out.println("You beat me!");
                    win++;
                }else if (ans > compChoice){
                    System.out.println("You beat me this time!");
                    win++;
                }else if (ans == compChoice){
                    tie++;
                    System.out.println("We tied!");
                }else if (ans < compChoice) {
                    System.out.println("Ha! I win this round!");
                    lose++;
                }
                
            }
            
            System.out.println("\nYou won " + win + " rounds.");
            System.out.println("We tied " + tie + " rounds.");
            System.out.println("I won " + lose + " rounds.");
            
            if(win>lose){
                System.out.println("\nCongrats! You won!");
            }else if(win==lose){
                System.out.println("\nWow, guess we tied this game!");
            }else if(win<lose){
                System.out.println("\nHaha! I'm THE master player!!!");
            }
            
            sc.nextLine();
            
            System.out.print("\nThat was fun! Want to go again? (y/n) : ");
            repeat = sc.nextLine();
            
        }while (!"n".equals(repeat));
        
        System.out.println("\nThanks for playing!");
        
    }
    
}
