/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.methods;

import java.util.Random;

/**
 *
 * @author heath
 */
public class BarelyControlledChaos {
     public static void main(String[] args) {
         
        Random r = new Random();

        String color = randomColor(r); // call color method here 
        String animal = randomAnimal(r); // call animal method again here 
        String colorAgain = randomColor(r); // call color method again here 
        
        int weight = randomNum(200, 5); // call number method, 
            // with a range between 5 - 200 
        int distance = randomNum(20, 10); // call number method, 
            // with a range between 10 - 20 
        int number = randomNum(20000, 10000); // call number method, 
            // with a range between 10000 - 20000 
        int time = randomNum(6, 2); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    public static String randomColor(Random r){
        int num = r.nextInt(5) + 1;
        
        switch(num){
            case 1: 
                return "red";
            case 2:
                return "blue";
            case 3:
                return "yellow";
            case 4:
                return "black";
            case 5:
                return "green";
            default:
                return "nothing";
        }
    }
    
    public static String randomAnimal(Random r){
        int num = r.nextInt(5) + 1;
        
        switch(num){
            case 1:
                return "snake";
            case 2:
                return "dog";
            case 3:
                return "cat";
            case 4:
                return "sheep";
            case 5:
                return "cow";
            default:
                return "nothing";
        }
        
    }
    
    public static int randomNum(int max, int min){
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
        //System.out.println(num);
    }
    
    

}
    

