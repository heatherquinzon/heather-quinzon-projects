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
public class ArrayTeamScores {
    public static void main(String[] args){
        int[] teamScores = {
            2, 45, 4, 8, 99,
            23, 67, 1, 88, 42 };
        
        System.out.println("For Loop: ");
        for(int i=0; i < teamScores.length; i++){
            System.out.println("Element " + i +
                    "= " + teamScores[i]);
        }
        
        System.out.println("\nEnhanced For Loop:");
        for(int num: teamScores){
            System.out.println("Element = " + num);
        }
        
        System.out.println("\n");
        
        String[][] cityTeamNames = {
        {"Cleveland", "Browns", "Cavs", "Indians"},//prints on first line
        {"Columbus", "Bluejackets", "Buckeyes"},//prints on second
        {"Pittsburgh", "Steelers", "Pirates", "Penguins"}//prints on third
        };
        
        for (int i = 0; i < cityTeamNames.length; i++) {
            for (int j = 0; j < cityTeamNames[i].length; j++) {
             System.out.print(cityTeamNames[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
