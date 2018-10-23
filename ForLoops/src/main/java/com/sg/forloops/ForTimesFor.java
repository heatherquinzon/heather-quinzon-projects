/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.forloops;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class ForTimesFor {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Which times table shall I recite?: ");
        int num = sc.nextInt();
        
        System.out.println("Actually, let's see if you can get the times table right!");
        System.out.println("\n");
        
        int ans=0;
        int score=0;
        
        for(int i=1; i <= 15; i++){
            System.out.print(i + " * " + num + " is ?: ");
            ans = sc.nextInt();
            
            if(ans == (i*num)){
                System.out.println("Correct!");
                score++;
            }else if(ans != (i*num)){
                System.out.println("Sorry no, the answer is: " + (i*num));
            }
        }
        
        if(score <= 7){
            System.out.println("\nYou got " + score + " correct.");
            System.out.println("You should probably study more.");
        } else if((score >= 7) && (score <= 13)){
            System.out.println("\nYou got " + score + " correct.");
        } else {
            System.out.println("You got " + score + " correct.");
            System.out.println("Congrats!");
        }
    }
    
}
