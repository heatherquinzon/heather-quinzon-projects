/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author heath
 */
public class FirstLast6 {

    public static boolean firstLast6(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            //numbers[i] = i;
            int first = numbers[0];

            for (int j = numbers.length - 1; j >= 0; j--) {
                int last = numbers[numbers.length -1];

                if ((first == 6) || (last == 6)) {
                    return true;
                }

            }

        }

        return false;
    }

    /*public static void main(String[] args) {

    }*/

}
