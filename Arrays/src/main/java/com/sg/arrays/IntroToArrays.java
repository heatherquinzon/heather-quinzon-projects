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
public class IntroToArrays {
    public static void main(String[] args) {
        //Declaring an array looks like
        // type[] typedArray;   
        
        //Initializing it can take a few forms
        int[] someNums = new int[10];
        int[] moreNums = {2001, 2010, 2020};
        
        //Accessing or storing data requires the array AND an index
        someNums[0] = 5; //puts # 5 in the 1st index of array which is ALWAYS 0
        someNums[1] = 3; //puts # 3 in the 2nd index of array
        int x = someNums[0] + someNums[1]; //retrieves and adds the 1st and 2nd
        //numbers together
        
        System.out.println(x); //should print out 8       
        
    }
    
}
