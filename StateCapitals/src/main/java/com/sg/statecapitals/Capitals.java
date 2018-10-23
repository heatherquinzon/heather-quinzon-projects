/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;

/**
 *
 * @author heath
 */
public class Capitals {

    String name;
    int population;
    int squareMileage;

    public Capitals(String name, int population, int squareMileage){
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    }
    
    public String returnCapitals(){
        return name + " | Pop: " + population + " | Area: " + squareMileage + " sq mi";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getSquareMileage() {
        return squareMileage;
    }

    public void setSquareMileage(int squareMileage) {
        this.squareMileage = squareMileage;
    }

    
    
}
