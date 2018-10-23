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
public class QuestForTheUserInput {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String yourName;
        String yourQuest;
        double velocityOfSwallow;
        
        System.out.print("What is your name? ");
        yourName = sc.nextLine();
        
        System.out.print("What is your Quest?! ");
        yourQuest = sc.nextLine();
        
        System.out.print("What is the airspeed velocity of an unladed swallow?! ");
        velocityOfSwallow = sc.nextDouble();
        
        System.out.println("\nHow do you know " + velocityOfSwallow + " is correct, "
        + yourName + " ,");
        System.out.println("When you didn't even know if the swallow was African or European!");
        System.out.println("Maybe skip answering things about birds and instead go " + yourQuest);
        
    }
    
}
