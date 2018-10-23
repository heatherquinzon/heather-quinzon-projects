/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.forloops;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class ForTimes {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Which times table shall I recite?: ");
        int num = sc.nextInt();
        
        for(int i=1; i <= 15; i++){
            System.out.println(i + " * " + num + " is: " + (i*num));
        }
        
        
    }
    
}
