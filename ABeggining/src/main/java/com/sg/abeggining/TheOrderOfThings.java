/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.abeggining;

/**
 *
 * @author heath
 */
public class TheOrderOfThings {
    
    public static void main(String[] args){
        
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlpaCentaurian";
        material = "platinum";
        purpose = "good";
        
        noun = "dragons";
        
        //using the + with string doesn't add, it concatenates! (sticks em together)
        System.out.println(number + opinion + size + age + shape + color
        + origin + material + purpose + noun);
    }
    
}
