/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dosandwhiles;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class StayPositive {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What number should I count down from?: ");
        int num = sc.nextInt();
        
        while ( num >= 0 ){
      
            System.out.println(num);         
            num--;
        }
    }
    
}
