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
public class Test {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What is your name? ");
        String name = sc.nextLine();
        
        System.out.println("What is your age? ");
        int age = Integer.parseInt(sc.nextLine());
        
        System.out.println("Where were you born? ");
        String hometown = sc.nextLine();
        
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Hometown: " + hometown);
    }
}
