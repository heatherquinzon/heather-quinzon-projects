/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.theproblemwithscanner;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class ScannerTest {
    public static void main(String[] args){
        
        String name;
        int age;
        int numComputers;
        String hometown;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter your name: ");
        name = sc.nextLine();
        System.out.println("Plese enter your age: ");
        age = sc.nextInt();
        System.out.println("Please enter the number of computers: ");
        numComputers = sc.nextInt();
        /* the problem with this code as is, is that after
        you type in numComputers and press enter, the sc.nextLine(); 
        from the text below takes into consideration that return and skips
        the rest of the code
        */
        sc.nextLine(); //can work and will consume the return aka "Enter"
        System.out.println("Enter your hometown: ");
        hometown = sc.nextLine();
                
        System.out.println("Your name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Number of computers: " + numComputers);
        System.out.println("Hometown: " + hometown);
    }
}
