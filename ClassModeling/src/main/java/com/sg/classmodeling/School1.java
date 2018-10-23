package com.sg.classmodeling;

/**
 *
 * @author heath
 */
public class School1 {

    private String name;
    private String description;
    private int numberOfClassrooms;
    private double squareFootage;
    private int studentCapacity;
    private Cafeteria cafeteria;

    /*
    creating the getters and setters
    right click
    click Insert Code
    click Getter and Setter
    automatically does all the bottom code
    */
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfClassrooms() {
        return numberOfClassrooms;
    }

    public void setNumberOfClassrooms(int numberOfClassrooms) {
        this.numberOfClassrooms = numberOfClassrooms;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(int studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

}
