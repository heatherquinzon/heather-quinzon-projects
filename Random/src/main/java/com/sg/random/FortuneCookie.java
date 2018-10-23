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
public class FortuneCookie {
    public static void main(String[] args){
        
        Random r = new Random();
        
        int x = r.nextInt(10) + 1;
        
        String fortune = "";
        switch(x){
            case 1:
                fortune = "Those aren’t the droids you’re looking for.";
                break;
            case 2:
                fortune = "Never go in against a Sicilian when death is on the line!";
                break; 
            case 3:
                fortune = "Goonies never say die.";
                break;
            case 4:
                fortune = "With great power, there must also come — great responsibility.";
                break;
            case 5:
                fortune = "Never argue with the data.";
                break;
            case 6:
                fortune = "Try not. Do, or do not. There is no try.";
                break;
            case 7:
                fortune = "You are a leaf on the wind; watch how you soar.";
                break;
            case 8:
                fortune = "Do absolutely nothing, and it will be everything that you thought it could be.";
                break;
            case 9:
                fortune = "Kneel before Zod.";
                break;
            case 10:
                fortune = "Make it so.";
                break;
        }
        
        System.out.println("Your Geek Fortune: " + fortune);
        
    }
}
