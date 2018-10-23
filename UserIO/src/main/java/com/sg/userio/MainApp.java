/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.userio;

/**
 *
 * @author heath
 */
public class MainApp {
    public static void main(String[] args) {
        
        UserIO u = new UserIOClass();
        
        u.readInt("Give me a num: ", 0, 100);
        
        
        
    }
}
