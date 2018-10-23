package com.sg.assignments;

import java.util.Scanner;

/**
 *
 * @author heath
 */

//this is a simple calculator for a healthy heart range
public class HealthyHearts {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What's your age? ");
        int age = Integer.parseInt(sc.nextLine());
        
        int maxHeartRate = 220 - age;
        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute.");
        
        int targetHRlow = (int) (maxHeartRate * 0.50);
        int targetHRhigh = (int) Math.round(maxHeartRate * 0.85);
        System.out.println("Your target HR Zone is " + targetHRlow + " - " 
        + targetHRhigh + " beats per minute.");
        
    }
}