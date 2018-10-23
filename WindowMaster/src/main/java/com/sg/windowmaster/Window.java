/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.windowmaster;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class Window {
   
    public static void main(String[] args){
        
        float height = 0;
        float width = 0;
        
        float areaOfWindow = 0;
        float cost = 0;
        float perimeterOfWindow = 0;
        
        Scanner myScanner = new Scanner(System.in);
        
        height = readValue("Please enter window height: ");
        width = readValue("Please enter window width: ");
        
        areaOfWindow = height * width;
        
        perimeterOfWindow = 2 * (height + width);
        
        cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));
        
        System.out.println("\nWindow height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = " + cost);
    }
    public static float readValue (String prompt){
    Scanner sc = new Scanner(System.in);
    System.out.print(prompt);
    String input = sc.nextLine();
    float floatVal = Float.parseFloat(input);
    return floatVal;

}
       

}


