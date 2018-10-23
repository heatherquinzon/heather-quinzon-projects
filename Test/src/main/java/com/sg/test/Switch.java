/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.test;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class Switch {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Give me a number from 1-7: ");
        int num = Integer.parseInt(sc.nextLine());
        
        String dayName = "";
        String dayType = "";
       
        switch (num){
            case 1:
                dayName = "Monday";
            case 2:
                dayName = "Tuesday";
            case 3: 
                dayName= "Wednesday";
            case 4: 
                dayName= "Thursday";
            case 5:
                dayName = "Friday";
                dayType = "Weekday";
                break;
            case 6:
                dayName = "Saturday";
            case 7:
                dayName = "Sunday";
                dayType = "Weekend";
                break;
            default:
                dayName = "(Invalid day)";
                dayType = "(Invalid type)";
        }
        
        System.out.println("It is " + dayName + " which is a(n) " + dayType + ".");
    }
}
