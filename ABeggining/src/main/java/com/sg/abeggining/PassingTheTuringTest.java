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
public class PassingTheTuringTest {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Hello there!");
        System.out.print("What's your name? ");
        String name = sc.nextLine();
        
        System.out.print("\nHi, " + name + " What's your favorite color? ");
        String color = sc.nextLine();
        
        System.out.println("\nHuh, " + color + "?" + " Mine's yellow!");
        
        System.out.println("\nI really like limes. They're my favorite fruit, too!");
        System.out.print("What's your favorite fruit, " + name + "? ");
        String fruit = sc.nextLine();
        
        System.out.println("\nReally? " + fruit + "?" + " That's wild!");
        System.out.print("Speaking of favorites, what's your favorite number? ");
        int favNum = Integer.parseInt(sc.nextLine());
        
        int sum = favNum * -7;
        System.out.println("\n" + favNum + " is a cool number. Mine's 3.");
        System.out.println("Did you know that " + favNum + " * -7" + " is " + sum + "?"
        + "That's a cool number too!");
        
        System.out.println("\nWell, thanks for talking to me, " + name + "!");
        
    }
}
