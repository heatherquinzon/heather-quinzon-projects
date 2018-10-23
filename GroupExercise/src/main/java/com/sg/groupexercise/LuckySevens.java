/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.groupexercise;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class LuckySevens {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        Random r = new Random();
        
        System.out.print("How much are you willing to bet?: ");
        int money = sc.nextInt();
        
        int dice1, dice2;
        int rolls=0;
        int maxMoney=money;
        int maxRolls=0;
        
        do{
            if (maxMoney < money){
                maxMoney = money;
                maxRolls = rolls;
            }
            
            dice1 = r.nextInt(6) + 1;
            dice2 = r.nextInt(6) + 1;
            
            if((dice1+dice2) == 7){
                money += 4;
            }else{
                money -= 1;
            }
        
            rolls++;
            
        } while (money != 0);
        
        System.out.println("You are broke after " + rolls + " rolls.");
        System.out.println("You shold have quit after " + maxRolls +
                " when you had " + maxMoney + " dollars.");
    }
    
}
