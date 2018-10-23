/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author heath
 */
public class StudentQuizGrades {
    public static void main(String[] args) {

        UserIO in = new UserIOClass();
        Map<String, List<Integer>> m = new HashMap<>();

        while (true) {
            switch (in.readString("=====What do you want to do?=====\n"
                    + "A = add another student\n"
                    + "B = remove a student\n"
                    + "C = Print a student's scores\n"
                    + "D = print each student's average score\n"
                    + "E = print the class's average score"
                    + "X = Exit Program\n")) {
                case "A":
                    String name = in.readString("\nGive me a student name: ");
                    m.put(name, new ArrayList<>());
                    String scores = in.readString("Give me a list of " + name + "'s scores: ");
                    String[] scoreArray = scores.split(", ");
                    for (String s : scoreArray) {
                        int i = Integer.parseInt(s);
                        (m.get(name)).add(i);
                    }
                    System.out.println();
                    break;
                case "B":
                    name = in.readString("\nWhich student? ");
                    m.remove(name);
                    break;
                case "C":
                    name = in.readString("\nWhich student? ");
                    System.out.println(name + "'s scores are: ");
                    for (int i : m.get(name)) {
                        System.out.print(i + ", ");
                    }
                    System.out.println();
                    break;
                case "D":
                    System.out.println();
                    for (String n : m.keySet()) {
                        int sum = 0;
                        for (int i : m.get(n)) {
                            sum += i;
                        }
                        System.out.println(n + "'s average score is: "
                                + (float) sum / m.get(n).size());
                    }
                    System.out.println();
                    break;
                case "E":
                    //to be implemented
                    System.out.println();
                case "X":
                    System.exit(0);
                default:
                    break;

            }
        }
    }
}
