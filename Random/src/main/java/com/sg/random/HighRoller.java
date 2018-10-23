package com.sg.random;

import java.util.Random;

/**
 *
 * @author heath
 */
public class HighRoller {
    public static void main(String[] args){
        Random diceRoller = new Random();

        int rollResult = diceRoller.nextInt(6) + 1;

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        } else if (rollResult < Math.max(rollResult, rollResult)){
            System.out.println("You rolled a critical! Nice Job!");
        }
    }
    
}
