/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.groupexercise;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class InterestCalculator {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How much money would you like to invest? ");
        double initialBalance = sc.nextDouble();
        System.out.print("What is the annual interest rate? ");
        double annualIntRate = sc.nextDouble();
        System.out.print("How many years would you like to keep the money in the fund? ");
        int years = sc.nextInt();
        
        double begBalance = initialBalance;
        double endBalance;
        double interestEarned;
        
        for(int i=1; i <= years; i++){
            
            System.out.println("\nYear " + i + ":");
            
            System.out.println("Beginning of year Balance: " + begBalance);
            
            endBalance = begBalance * (1 + (annualIntRate / 100));
            
            interestEarned = endBalance - begBalance;
            System.out.println("You earned: " + interestEarned + " for this year.");
            
            System.out.println("End of year Balance: " + endBalance);
            
            begBalance = endBalance;
        }
        
    }
    
}
