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
public class DoWhile {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int x=0;
        
        do{
            System.out.print("Give me a num from 1-10: ");
            x = sc.nextInt();
        } while (x <= 0 || x >10);
        
        System.out.println("You entered: " + x);
    }
    
}
