/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author heath
 */
public class LocalDateRandom {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
////        String date = "09/10/2018";
//        LocalDate ld = LocalDate.parse(date, formatter1);
//        String formatted1 = ld.format(formatter1);
//        System.out.println(formatted1);
//        
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
//        String formatted2 = ld.format(formatter2);
//        System.out.println(formatted2);

//        LocalDate now = LocalDate.now();
//        System.out.println(now);
//
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//
//        System.out.println("\nGimme a date (mm/dd/yyy): ");
//        LocalDate theirDate = LocalDate.parse(sc.nextLine(), formatter1);
//        String formatted1 = theirDate.format(formatter1);
//        System.out.println(formatted1);
//
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
//        String formatted2 = theirDate.format(formatter2);
//        System.out.println(formatted2);

          DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
          LocalDate now = LocalDate.now();
          System.out.println(now);
          
          String ld = now.format(formatter1);
          System.out.println(ld);
          
          DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMddyyyy");
          ld = now.format(formatter2);
          System.out.println(ld);

         
         
    }
}
