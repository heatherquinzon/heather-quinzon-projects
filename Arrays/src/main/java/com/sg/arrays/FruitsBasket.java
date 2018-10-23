/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrays;

/**
 *
 * @author heath
 */
public class FruitsBasket {
 
    public static void main(String[] args) {
        
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", 
            "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", 
            "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", 
            "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", 
            "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"
        };
        
        int o=0;
        int a=0;
        
        System.out.println("Total# of Fruit in Basket: " + fruit.length);
        
        for(int i=0; i<fruit.length; i++){
            if(fruit[i] == "Orange"){
                o++;
            }
            if(fruit[i] == "Apple"){
                a++;
            }
        }
        
        System.out.println("Number of Apples: " + a);
        System.out.println("Number of Oranges: " + o);
        
        System.out.println("\nSame code but with seperate index.");
        
        String[] Apple= new String[a];
        int appleIndex=0;
        String[] Orange= new String[o];
        int orangeIndex=0;
        
        
        for(int i=0; i<fruit.length; i++){
            if(fruit[i].equals("Orange")){
               Orange[orangeIndex] = fruit[i];
               orangeIndex++;
            }
            if(fruit[i].equals("Apple")){
                Apple[appleIndex] = fruit[i];
                appleIndex++;
            }
            
        }
        
        System.out.println("Number of Apples: " + appleIndex);
        System.out.println("Number of Oranges: " + orangeIndex);
    }
}
