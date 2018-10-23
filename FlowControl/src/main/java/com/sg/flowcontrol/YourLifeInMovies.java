/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flowcontrol;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class YourLifeInMovies {
    public static void main(String [] args){
            
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Hey let's play a game! What's your name? ");
        String name = sc.nextLine();
        
        System.out.print("\nOk, " + name + ", " 
                + "What year were you born in? ");
        int year = Integer.parseInt(sc.nextLine());
        
        System.out.println("Well " + name + "...");
        
        if(year <= 2000){
            System.out.println("Did you know what Pixar's Up came out half a year ago?");
        }
        
        if(year <= 1995){
            System.out.println("The first Harry Potter came out over 15 years ago.");
        }
        
        if(year <= 1985){
            System.out.println("Space Jam came out not last decade, but the one before THAT.");
        }
        
        if(year <= 1975){
            System.out.println("The original Jurassic Park release is closer to "
                    + "the date of the first lunar landing that it is to today.");
        }
        
        if (year <= 1965){
            System.out.println("MASH TV series has been around for almost half a century!");
        }
        
    }
}
