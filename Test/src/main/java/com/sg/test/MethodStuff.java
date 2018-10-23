/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.test;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class MethodStuff {
    public static void main(String[] args){
        /*
        String a = "Kyle";
        String b = "Rudy";
        
        System.out.println(a.compareTo(b));
        //prints neg num bcs K comes before R
        
        System.out.println(b.compareTo(a));
        //prints pos num bcs R comes after K
        
        System.out.println("Kyle".compareTo(a));
        //prints 0 (zero) bcs they're even
        
        System.out.println("Karen".compareTo(a));
        //prints neg num bcs the 2nd letter in Karen is
        //before 2nd letter in Kyle
        
        System.out.println("kyle".compareTo(a));
        //prints pos bum bcs lower case letters comes after upper case
        */

        Scanner sc = new Scanner(System.in);
        
        String n = askForName(sc);
        printName(n);
        System.out.println("Name length: " + getLength(n));
        String a = askForName(sc);
        printName(a);
        System.out.println("Name length: " + getLength(a));
        

}
    public static String askForName(Scanner sc){
        System.out.print("What's your name?: ");
        return sc.nextLine();
    }
    
    /*public static Scanner getScanner(){
        return new Scanner(System.in);
    }*/
    
    public static void printName(String name){
        if("Kyle".equals(name)){
            return;
        }
        //so, when you run this, if you input Kyle inside inside askForName
        //it skips the bottom code, which won't print out Kyle
        System.out.println("Your name: " + name);
    }
    
    public static int getLength(String name){
        
        return name.length();
    }
    
}
