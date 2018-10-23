/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.test;

import java.util.Random;

/**
 *
 * @author heath
 */
public class RandomStuff {
    public static void main(String[] args){
        
    Random rGen = new Random();
    //can put a seed inside random and itll run the same
    //amount of "random" numbers everytime you run it
        
    for(int i=0; i < 10; i++){
        int rInt = rGen.nextInt(10) + 1;
        //int rInt = (int) (Math.random()*10 + 1); --same code as above
        System.out.println(rInt);
    }
    
    }
}
