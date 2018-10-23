/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.random;

import java.util.Random;

/**
 *
 * @author heath
 */
public class Opinionator {
    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("I can't decide what animal I like the best.");
        System.out.println("I know! Random can decide FOR ME!");

        int x = randomizer.nextInt(5) + 1;
        
        /*for(int i=0; i<100; i++){
            int x = randomizer.nextInt(5);
            System.out.println(x);
        }*/

        System.out.println("The number we chose was: " + x);

        switch (x) {
            case 0:
                System.out.println("Llamas are the best!");
                break;
            case 1:
                System.out.println("Dodos are the best!");
                break;
            case 2:
                System.out.println("Woolly Mammoths are DEFINITELY the best!");
                break;
            case 3:
                System.out.println("Sharks are the greatest, they have their own week!");
                break;
            case 4:
                System.out.println("Cockatoos are just so awesomme!");
                break;
            case 5:
                System.out.println("Have you ever met a Mole-Rat? They're GREAT!");
                break;
            default:
                break;
        }

        System.out.println("Thanks Random, maybe YOU'RE the best!");
        
        /*
        what was wrong with the code was the random number, it could
        never reach case 5 bcs the #5 would never go in
        */
    }
}
