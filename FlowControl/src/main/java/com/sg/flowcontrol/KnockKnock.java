
package com.sg.flowcontrol;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class KnockKnock {
      
    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();

        //if this is nameGuess == Marty McFly code doesn't work even
        //if you type in Marty Mcfly, itll go to the else statement
        if(nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!
        }else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
    
}
