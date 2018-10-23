/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.abeggining;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class DoItBetter {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Hey! How many miles can you run? ");
        int miles = Integer.parseInt(sc.nextLine());
        System.out.println("Well I can run " + (miles * 2 + 1));
        
        System.out.print("\nWell... how many hotdogs can you eat? ");
        int hotdogs = Integer.parseInt(sc.nextLine());
        System.out.println("Haha! Well I can eat " + (hotdogs * 2 + 1) + " hotdogs.");
        
        System.out.print("\nOk...one last time. How many languages do you know? ");
        int languages = Integer.parseInt(sc.nextLine());
        System.out.println("That's a lot! But I know " + (languages * 2 + 1) + " languages.");
        
        System.out.println("\nBetter luck next time!");      
        
    }
}
