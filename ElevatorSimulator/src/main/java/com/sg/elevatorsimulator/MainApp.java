/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.elevatorsimulator;

/**
 *
 * @author heath
 */
public class MainApp {

    public static void main(String[] args) {

        int floors = 1;

        UserIO io = new UserIOClass();

        boolean quit = true;

        int userFloors;

        io.print("WELCOME TO THE ELEVATOR SIMULATOR!");
        io.print("YOU ARE CURRENTLY IN THE MAIN FLOOR");

        while (quit) {

            io.print("\nYOU ARE CURRENTLY ON FlOOR " + floors);

            int choice;
            if (floors > 0 && floors < 12) {
                choice = io.readInt("Would you like to go 1)Up or 2)Down ", 1, 2);
            } else if (floors == 0) {
                choice = io.readInt("Would you like to go 1) Up? ", 1, 1);
            } else if (floors == 12) {
                choice = io.readInt("Would you like go 2) Down? ", 2, 2);
            } else {
                io.print("INVALID FLOOR");
            }

            io.print("Which floor would you like to go to? ");
            for (int i = 0; i <= 12; i++) {
                io.print("" + i);
            }
            floors = io.readInt("Which floor?: ");

            io.print("Welcome to floor " + floors);

            String continueChoice = io.readString("Would you like to go again? (yes/no)");
            if (continueChoice.equalsIgnoreCase("no")) {
                quit = false;
            }

        }
        
        io.print("THANK YOU!!");

    }
}
