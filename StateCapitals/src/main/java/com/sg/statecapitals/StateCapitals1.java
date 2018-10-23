/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author heath
 */
public class StateCapitals1 {
    public static void main(String[] args) {
        
        Map<String, String> state = new HashMap<>();
        
        state.put("Alabama", "Montgomery");
        state.put("Alaska", "Juneau");
        state.put("Arizona", "Pheonix");
        state.put("Arkansas", "Little Rock");
        state.put("California", "Sacramento");
        
        Set<String> keys = state.keySet();
        System.out.println("STATES:");
        System.out.println("==========");
        for(String s : keys){
            System.out.println(s);
        }
        
        Collection<String> values = state.values();
        System.out.println("\nCAPITALS:");
        System.out.println("==========");
        for(String v : values){
            System.out.println(v);
        }
        
        System.out.println("\nSTATES/CAPITALS PAIRS:");
        System.out.println("==============================");
        for(String s : keys){
            String v = state.get(s);
            System.out.println(s + " - " + v);
            
        }        
    }
    
}
