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
public class Factorizor {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int count=0;
        int sumOfFactors=0;
        
        System.out.print("What number would like to factor? ");
        int factorNum = sc.nextInt();
        
        System.out.println("The factors of " + factorNum + " are:");
        
        for(int i=1; i<factorNum; i++){
            if ( factorNum % i == 0 ){
                System.out.println(i);
                count++;
                sumOfFactors += i;
            } 
        }
        
        System.out.println("Total number of factors for " + factorNum + " is: " + count);
        
        if (count == 1){
            System.out.println(factorNum + " is a prime number.");
        } else {
            System.out.println(factorNum + " is not a prime number.");
        }
        
        if (sumOfFactors == factorNum){
            System.out.println(factorNum + " is a perfect number.");
        } else {
            System.out.println(factorNum + " is not a perfect number.");
        }
        
    }
    
}
