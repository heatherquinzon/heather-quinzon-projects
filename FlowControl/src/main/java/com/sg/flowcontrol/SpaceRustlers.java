/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flowcontrol;

/**
 *
 * @author heath
 */
public class SpaceRustlers {
    public static void main(String[] args) {

        int spaceships = 10;
        int aliens = 25;
        int cows = 100;

        if(aliens > spaceships){
            System.out.println("Vrroom, vroom! Let's get going!");
        } else{
            System.out.println("There aren't enough green guys to drive these ships!");
        }
        /* this if else will run line 20 if the amount of aliens is greater
        than the amount of spaceships, otherwise it'll run line 22 */

        if(cows == spaceships){
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        } else if (cows > spaceships){
            System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }
        // w/out the else if else if, it runs the same thing
        
        /*
        if the amount of cows equals spaceship, itll run line 28
        if cows is greater than spaceship itll run 30
        and if spaceships is greater than cows itll run 32
        */
        
        if (aliens > cows){
            System.out.println("Hurrah, we've got grub! Hamburger part on Alpha Centauri!");
        } else if (aliens <= cows){
            System.out.println("Oh no! The herds got restless and took over!"
                    + "Looks like we're hamburger now!!");
        }
    }
    
}
