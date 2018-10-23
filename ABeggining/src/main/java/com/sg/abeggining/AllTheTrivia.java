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
public class AllTheTrivia {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("1,024 Gigabytes is equal to one what? ");
        String bytes = sc.nextLine();
        System.out.print("What is our planet called? ");
        String planet = sc.nextLine();
        System.out.print("What school do we go to? ");
        String school = sc.nextLine();
        System.out.print("What do we need to breath? ");
        String breath = sc.nextLine();
        
        System.out.println("\nWow, 1,024 Gigabytes is a " + planet);
        System.out.println("I didn't know that our planet is called " + breath);
        System.out.println("That's amazing that we go to " + bytes + " for school!");
        System.out.println("I didn't realize we needed " + school + " to breath!!");
        
    }
    
}
