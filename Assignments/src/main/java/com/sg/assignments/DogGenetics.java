/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.assignments;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class DogGenetics {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        System.out.println("Hi there! Welcome to DoggyGenetics where we");
        System.out.println("do genetic analysis to tell you what your");
        System.out.println("dog's ancesty is like!");
        System.out.println("***ALL FOR FREE!!!***");
        System.out.print("All I need is your dog's name: ");
        String dogName = sc.nextLine();
        
        System.out.println("\nWOW! What an interesting doggo you got there!");
        System.out.println("I have " + dogName + "'s prestigious background "
        + "right here!");
        System.out.println(dogName + " is: ");
        
        System.out.println("\n");
        
        int sum=100;
        
        for(int i=0; i<4; i++){
            
            int num = r.nextInt(sum);
            
            sum -= num;
            
            switch (i) {
                case 0:
                    System.out.println(num + "% St Bernard");
                    break;
                case 1:
                    System.out.println(num + "% Chihuahua");
                    break;
                case 2:
                    System.out.println(num + "% Puggle");
                    break;
                case 3:
                    System.out.println(num + "% Golden Retriever");
                    break;
                default:
                    break;
            }
            
        }
        
        System.out.println(sum + "% Husky");
        
    }
}
