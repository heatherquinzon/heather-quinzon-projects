package com.sg.flowcontrol;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class FieldDay {
    public static void main(String[] args){
        
        String lastName = "";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("What's your last name? ");
        lastName = sc.nextLine();
        
        if(lastName.charAt(0) < 'B'){
            System.out.println("You're in team Red Dragons!");
        } else if (lastName.charAt(0) >= 'B' && lastName.charAt(0) < 'D'){
            System.out.println("You're in team Dark Wizards!");
        } else if (lastName.charAt(0) >= 'D' && lastName.charAt(0) < 'H'){
            System.out.println("You're in team Moving Castles!");
        } else if(lastName.charAt(0) >= 'H' && lastName.charAt(0) < 'P'){
            System.out.println("You'te in team Golden Snitches");
        } else if(lastName.charAt(0) >= 'P' && lastName.charAt(0) < 'V'){
            System.out.println("You're in team Night Guard");
        } else {
            System.out.println("You're in team Black Holes!");
        }
        
        System.out.println("Good luck!");
                
    }
}
