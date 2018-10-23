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
public class MiniMadLibs {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Let's play MAD LIBS!");
        
        System.out.print("\nI need a noun: ");
        String noun1 = sc.nextLine(); //1
        System.out.print("Now I need an adjective: ");
        String adj1 = sc.nextLine(); //2
        System.out.print("Another noun: ");
        String noun2 = sc.nextLine(); //3
        System.out.print("Now, a number: ");
        int num1 = Integer.parseInt(sc.nextLine()); //4
        System.out.print("Another adj: "); 
        String adj2 = sc.nextLine(); //5
        System.out.print("I need a plural noun: ");
        String noun3 = sc.nextLine(); //6
        System.out.print("Another one: ");
        String noun4 = sc.nextLine(); //7
        System.out.print("One more: ");
        String noun5 = sc.nextLine(); //8
        System.out.print("Now I need a ver (present tense): ");
        String verb1 = sc.nextLine(); //9
        System.out.print("Same verb (past tense): ");
        String verb2 = sc.nextLine(); //10
        
        System.out.println("\n*** COOL COOL, NOW LETS GET MAD (libs) ***");
        
        System.out.println("\n" + noun1 + ":" + "the " + adj1 + " frontier."
                + " These are the voyages of the starship " + noun2 
                + "." );
        System.out.println(" Its " + num1 + " mission: to explore strange "
                + adj2 + noun3 + ", " + "to seek out " + adj2 + noun4
                + " and " + adj2 + noun5 + ", to boldly " + verb1 
                + " where no one has " + verb2 + " before.");
    }
}
