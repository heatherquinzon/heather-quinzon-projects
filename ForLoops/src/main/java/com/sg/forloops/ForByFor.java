/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.forloops;

/**
 *
 * @author heath
 */
public class ForByFor {
    public static void main(String[] args){
        
        /*
        1st for loop (i) prints left most | going down
        2nd for loop (j) prints the 3 other | horizontally and vertically
        3rd for loop (k) prints * inside the | inside the 2nd for loop
        */
        
        for (int i=1; i<=3; i++){
            System.out.print("|");
            
            for(int j=1; j<=3; j++){
                
                for(int k=1; k<=3; k++){
                    
                    if((j==2)&&(i==2)){
                        System.out.print("#");
                    } else if ((j==2)) {
                        System.out.print("$");
                    } else if ((j!=2)&&(i==2)){
                        System.out.print("@");
                    } else {
                        System.out.print("*");
                    }
                    
                }
                
                System.out.print("|");
            }
            
            System.out.println("");
        }
    }
    
}
