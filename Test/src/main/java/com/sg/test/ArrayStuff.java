/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.test;

/**
 *
 * @author heath
 */
public class ArrayStuff {
    public static void main(String[] args){
        int[] iArray = new int[10];
        
        System.out.println("Before Array");
        for(int i=0; i < iArray.length; i++){
            System.out.println(iArray[i]);
        }
        
        changeArray(iArray);
        
        System.out.println("After Array");
        for(int i=0; i < iArray.length; i++){
            System.out.println(iArray[i]);
        }
        
    }
    
    public static void changeArray(int[] arr){
        arr[0] = 10;
        //changing it in memory
    }
    
}
