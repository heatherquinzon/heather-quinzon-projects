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
public class TheCount {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU!***\n");
        
        System.out.print("Start at: ");
        int start = sc.nextInt();
        System.out.print("Stop at: ");
        int end = sc.nextInt();
        System.out.print("Count by: ");
        int countBy = sc.nextInt();
        
        int counter=0;
        //the counter and the code for counter
        //prints the num out horizontaly instead of vertically
        //and prints a new line for every 3
        
        for(int i = start; i <= end; i += countBy){
            
            System.out.print(i + " ");
            counter++;
            
            if (counter == 3){
                counter = 0;
                System.out.print(" - Ah ah ah!");
                System.out.println();
            }
        
        }
        
    }
    
}
