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
public class TriviaNight {
    public static void main(String[] args){
        
        System.out.println("It's TRIVIA NIGHT! Are you ready????\n");
        
        int score=0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("FIRST QUESTION!");
        System.out.println("Which fictional city is the home of batman? ");
        System.out.println("1) Gotham");
        System.out.println("2) Catham");
        System.out.println("3) Los Angels");
        System.out.println("4) Denver");
        
        System.out.print("\nYOUR ANSWER: ");
        int ans1 = Integer.parseInt(sc.nextLine());
        
        if (ans1 == 1){
            score++;
        }
        
        System.out.println("\nSECOND QUESTION!");
        System.out.println("What is NOT a Hogwart's House?");
        System.out.println("1) Slytherin");
        System.out.println("2) Powerpuff");
        System.out.println("3) Ravenclaw");
        System.out.println("4) Gryffindor");
        
        System.out.print("\nYOUR ANSWER: ");
        int ans2 = Integer.parseInt(sc.nextLine());
        
        if(ans2 == 2){
            score++;
        }
        
        System.out.println("\nFINAL QUESTION!");
        System.out.println("How many sides are in a pentagon?");
        System.out.println("1) 3");
        System.out.println("2) 2");
        System.out.println("3) 4");
        System.out.println("4) 5");
        
        System.out.print("\nYOUR ANSWER: ");
        int ans3 = Integer.parseInt(sc.nextLine());
        
        if (ans3 == 4){
            score++;
        }
        
        if (score > 0){
            System.out.println("\nNice job! You got " + score +" right!");
        } else if (score == 0){
            System.out.println("\nYikes! You got 0 correct. \nBetter luck next time!");
        }
    }
}
