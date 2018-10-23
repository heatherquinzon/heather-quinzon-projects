/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.elevatorsimulator;

import java.util.Scanner;

/**
 *
 * @author heath
 */
public class UserIOClass implements UserIO{
    
    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double newDouble = Double.parseDouble(sc.nextLine());
        return newDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.print(prompt);
        double newDouble = Double.parseDouble(sc.nextLine());

        while (newDouble < min || newDouble > max) {
            System.out.println("OUT OF RANGE");
            System.out.print("Try again: ");
            newDouble = Double.parseDouble(sc.nextLine());
        }

        return newDouble;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float newFloat = Float.parseFloat(sc.nextLine());
        return newFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.print(prompt);
        float newFloat = Float.parseFloat(sc.nextLine());

        while (newFloat < min || newFloat > max) {
            System.out.println("OUT OF RANGE");
            System.out.print("Try again: ");
            newFloat = Float.parseFloat(sc.nextLine());
        }

        return newFloat;
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int newInt = Integer.parseInt(sc.nextLine());
        return newInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.print(prompt);
        int newInt = Integer.parseInt(sc.nextLine());

        while (newInt < min || newInt > max) {
            System.out.println("OUT OF RANGE");
            System.out.print("Try again: ");
            newInt = Integer.parseInt(sc.nextLine());
        }

        return newInt;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long newLong = Long.parseLong(sc.nextLine());
        return newLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.print(prompt);
        long newLong = Long.parseLong(sc.nextLine());

        while (newLong < min || newLong > max) {
            System.out.println("OUT OF RANGE");
            System.out.print("Try again: ");
            newLong = Long.parseLong(sc.nextLine());
        }

        return newLong;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String newString = sc.nextLine();
        return newString;
    }

    
}
