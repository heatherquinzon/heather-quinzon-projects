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
public class StateCapitals2 {

    public static void main(String[] args) {

        Map<String, Capitals> state = new HashMap<>();

        /*
        instead of doing 
        Capitals Alabama = new Capitals("Montgomery", 205000, 156);
        and calling it as
        state.put("Alabama", Alabama);
        */
        state.put("Alabama", new Capitals("Montgomery", 205000, 156));
        state.put("Alaska", new Capitals("Juneau", 31000, 3255));
        state.put("Arizona", new Capitals("Pheonix", 1445000, 517));
        state.put("Arkansas", new Capitals("Little Rock", 193000, 116));

        System.out.println("STATE/CAPITAL PAIRS:");
        System.out.println("=============================");
        Set<String> states = state.keySet();
        for (String currentState : states) {
            System.out.println(currentState + " - "
                    + state.get(currentState).returnCapitals());
        }

    }

}
