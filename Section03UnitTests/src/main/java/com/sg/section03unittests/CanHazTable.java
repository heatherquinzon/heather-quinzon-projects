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
public class CanHazTable {

    public static int canHazTable(int yourStyle, int dateStyle) {

        if ((yourStyle >= 8) || (dateStyle >= 8)) {
            return 2;
        } else if ((yourStyle <= 2) || (dateStyle <= 2)) {
            return 0;
        } else {
            return 1;
        }

    }

    public static void main(String[] args) {

        System.out.println(canHazTable(5, 10));
        System.out.println(canHazTable(5, 2));
        System.out.println(canHazTable(5, 5));
    }
}
