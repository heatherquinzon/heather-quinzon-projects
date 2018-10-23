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
public class SimpleSort {
    
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[firstHalf.length+secondHalf.length];
        //originally: int[] wholeNumbers = new int[24];
        //but the code above is if u dont know how big the two are total
        
        int count=0;
        int temp;
        
        for(int i=0; i<firstHalf.length; i++){
            wholeNumbers[i] = firstHalf[i];
            count++;
        }
            
        for(int j=0; j<secondHalf.length; j++){
            wholeNumbers[count++] = secondHalf[j];
        }
        
        System.out.println("Here you go - all nice and ordered:");
        for(int i=0; i<wholeNumbers.length; i++){
            for (int j=0; j<wholeNumbers.length-1; j++){
                if(wholeNumbers[j] > wholeNumbers[j+1]){
                    temp = wholeNumbers[j];
                    wholeNumbers[j] = wholeNumbers[j+1];
                    wholeNumbers[j+1] = temp;
                }
            }
            System.out.print(wholeNumbers[i] + " ");
        }
    }    
}
