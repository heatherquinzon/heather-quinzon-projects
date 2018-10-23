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
public class TwoForsAndTenYearsAgo {
     public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }
        //range from start-stop is 0-10
        //this is clearer to understand counting back

        System.out.println("\nI can count backwards using a different way too...");

        for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + i);
        }
        //range from start-stop is year - (year - 20)
        //counts back 20 years
        
    }
    
}
