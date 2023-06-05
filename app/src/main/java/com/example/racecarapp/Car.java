package com.example.racecarapp;

import java.io.Serializable;

/**
 * This is a template to create cars in the racing game
 * @author Luke Porter
 * @version 1.0
 */
public class Car implements Serializable {


    //minimum 5 instance variables
    /**
     * brand of car
     */
    private String brand;
    /**
     * color of car
     */
    private String color;
    /**
     * laps of car
     */
    private int laps;
    /**
     * current speed of car
     */
    private double currentSpeed;
    /**
     * cans of nitro of car
     */
    private int nitroCans;
    /**
     * Car iD
     */
    private int carID;
    /**
     * printed String
     */
    private String carTxt;


    //minimum 1 static variable for tracking object ID
    /**
     * total number of cars
     */
    private static int numCars;

    //minimum 3 constructors (1 default) that track object ID
    /**
     * Default Constructor with no parameters
     * <br>Preconditions: none
     * <br>Post-conditions: creates a Car instance with brand Toyota,
     *    color grey, laps 0, a current speed of 0, 2 nitro
     *    cans, and a Car ID
     */
    public Car()
    {
        this.brand = "Honda";
        this.color = "grey";
        this.laps = 1;
        this.currentSpeed = 0;
        this.nitroCans = 2;
        numCars++;
        this.carID = numCars;
    }

    /**
     * Constructor that initializes the brand and color of the Car
     * <br>Preconditions: brand is a nonempty string, color is a
     *    nonempty string
     * <br>Post-conditions: creates a Car instance with brand "brand",
     *    color "color", laps 0, a current speed of 0, 2 nitro
     *    cans, and a Car ID
     * @param brand: brand of car
     * @param color: color of car
     */
    public Car(String brand, String color)
    {
        this.brand = brand;
        this.color = color;
        this.laps = 1;
        this.currentSpeed = 0;
        this.nitroCans = 2;
        numCars++;
        this.carID = numCars;
    }


    //get methods for each instance variable
    /**
     * Method that returns the brand of the car
     * <br>Precondition: car must have a brand
     * <br>Post-condition: returns brand of car as a string
     * @return brand of car
     */
    public String getBrand()
    {
        return brand;
    }

    /**
     * Method that returns the laps of the car
     * <br>Precondition: car must have a laps
     * <br>Post-condition: returns laps of car as an int
     * @return laps of car
     */
    public int getLaps()
    {
        return laps;
    }
    /**
     * Method that returns the currentSpeed of the car
     * <br>Precondition: car must have a currentSpeed
     * <br>Post-condition: returns currentSpeed of car as a double
     * @return currentSpeed of car
     */
    public double getCurrentSpeed()
    {
        return currentSpeed;
    }
    /**
     * Method that returns the number of nitro cans in the car
     * <br>Precondition: car must have nitro cans
     * <br>Post-condition: returns nitroCans of car as an int
     * @return nitroCans of car
     */
    public int getNumNitroCans()
    {
        return nitroCans;
    }


    //set methods for each instance variable


    public void setNitroCans(int nitroCans) {
        this.nitroCans = nitroCans;
    }

    /**
     * Method that sets the laps of the car
     * <br>Precondition: none
     * <br>Post-condition: sets the laps of the car as an int
     * @param newLaps: new laps of the Car
     */
    public void setLaps(int newLaps)
    {
        laps = newLaps;
    }

    /**
     * Method that sets the current speed of the car
     * <br>Precondition: none
     * <br>Post-condition: sets the current speed of the car as a double
     * @param newCurrentSpeed: new currentSpeed of the Car
     */
    public void setCurrentSpeed(double newCurrentSpeed)
    {
        currentSpeed = newCurrentSpeed;
    }



    //3 other mutator methods for object interaction
    /**
     * Method that runs when the car uses nitro
     * <br>Precondition: none
     * <br>Post-condition: decreases nitroCans by one and increases
     *    currentSpeed by 10
     */
    public void useNitro()
    {
        if (nitroCans > 0)
        {
            nitroCans--;
            currentSpeed += 15;
        }
        else
        {
            carTxt = "But you're out of nitro cans! Take a pit stop to replenish.";
            Track.setTrackTxt(carTxt);
            drive();
        }
    }

    /**
     * Method that runs when the car laps
     * <br>Precondition: none
     * <br>Post-condition: increases laps by one and decreases
     *    currentSpeed by 10
     */
    public void lap()
    {
        laps++;
        currentSpeed -=10;
    }

    /**
     * Method that runs when the car does a pit stop
     * <br>Precondition: none
     * <br>Post-condition: increases nitroCans by one and decreases
     *    currentSpeed by 3 - (2 for each nitro canister)
     */
    public void pitStop()
    {
        nitroCans++;
        currentSpeed -= (3 - (2*nitroCans));
    }

    /**
     * Method that runs when the car simply drives
     * <br>Preconditions: none
     * <br>Post-condition: either slows down or speeds up the car by 5 depending
     *    on a coin flip
     */
    public void drive()
    {
        int i = (int) (2*Math.random());
        if (i == 0)
        {
            currentSpeed += 5;
            carTxt = "\nThe " + brand + " gains momentum while driving!";
            Track.setTrackTxt(carTxt);
        }
        else
        {
            currentSpeed -=5;
            carTxt = "\nThe " + brand + " loses speed!";
            Track.setTrackTxt(carTxt);
        }
    }

}