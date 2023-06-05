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
     * <br>Postconditions: creates a Car instance with brand Toyota,
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
     * <br>Postconditions: creates a Car instance with brand "brand",
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

    /**
     * Constructor that initializes the brand, color, and number of
     *    nitro cans in the Car.
     * <br>Preconditions: brand is a nonempty string, color is a
     *    nonempty string, nitroCans is a nonempty int
     * <br>Postconditions: creates a Car instance with brand "brand",
     *    color "color", laps 0, a current speed of 0,
     *    nitroCans "nitroCans", and a Car ID
     * @param brand: brand of car
     * @param color: color of car
     * @param nitroCans: number of nitro cans in the car
     */
    public Car(String brand, String color, int nitroCans)
    {
        this.brand = brand;
        this.color = color;
        this.laps = 1;
        this.currentSpeed = 0;
        this.nitroCans = nitroCans;
        numCars++;
        this.carID = numCars;
    }

    //get methods for each instance variable
    /**
     * Method that returns the brand of the car
     * <br>Precondition: car must have a brand
     * <br>Postcondition: returns brand of car as a string
     * @return brand of car
     */
    public String getBrand()
    {
        return brand;
    }
    /**
     * Method that returns the color of the car
     * <br>Precondition: car must have a color
     * <br>Postcondition: returns color of car as a string
     * @return color of car
     */
    public String getColor()
    {
        return color;
    }
    /**
     * Method that returns the laps of the car
     * <br>Precondition: car must have a laps
     * <br>Postcondition: returns laps of car as an int
     * @return laps of car
     */
    public int getLaps()
    {
        return laps;
    }
    /**
     * Method that returns the currentSpeed of the car
     * <br>Precondition: car must have a currentSpeed
     * <br>Postcondition: returns currentSpeed of car as a double
     * @return currentSpeed of car
     */
    public double getCurrentSpeed()
    {
        return currentSpeed;
    }
    /**
     * Method that returns the number of nitro cans in the car
     * <br>Precondition: car must have nitro cans
     * <br>Postcondition: returns nitroCans of car as an int
     * @return nitroCans of car
     */
    public int getNumNitroCans()
    {
        return nitroCans;
    }
    /**
     * Method that returns the ID of the car
     * <br>Precondition: car must have an ID
     * <br>Postcondition: returns ID of car as an int
     * @return ID of car
     */
    public int getCarID()
    {
        return carID;
    }
    /**
     * Method that returns the String that holds text
     */

    public static int getTotalNumCars()
    {
        return numCars;
    }

    //toString method
    /**
     * Method that returns all the attributes of a car in a String
     * <br>Precondition: the car is initilized
     * <br>Postcondition: returns the brand, color, laps, currentSpeed, nitroCans,
     *    and Car ID of the car as a String
     * @return brand of car, color of car, laps of car, current speed of car,
     *    number of nitro cans of car, ID of car
     */
    public String toString()
    {
        return  "Brand:\t\t  " + brand +
                "\nColor:\t\t  " + color +
                "\nLaps:\t\t  " + laps +
                "\nCurrent Speed:\t  " + currentSpeed +
                "\nNitro Cans:\t  " + nitroCans +
                "\nCar ID:\t\t  " + carID;
    }

    //set methods for each instance variable
    /**
     * Method that sets the brand of the car
     * <br>Precondition: none
     * <br>Postcondition: sets the brand of the car as a string
     * @param newBrand: new brand of the Car
     */
    public void setBrand(String newBrand)
    {
        brand = newBrand;
    }

    /**
     * Method that sets the color of the car
     * <br>Precondition: none
     * <br>Postcondition: sets the color of the car as a string
     * @param newColor: new color of the Car
     */
    public void setColor(String newColor)
    {
        color = newColor;
    }

    /**
     * Method that sets the laps of the car
     * <br>Precondition: none
     * <br>Postcondition: sets the laps of the car as an int
     * @param newLaps: new laps of the Car
     */
    public void setLaps(int newLaps)
    {
        laps = newLaps;
    }

    /**
     * Method that sets the current speed of the car
     * <br>Precondition: none
     * <br>Postcondition: sets the current speed of the car as a double
     * @param newCurrentSpeed: new currentSpeed of the Car
     */
    public void setCurrentSpeed(double newCurrentSpeed)
    {
        currentSpeed = newCurrentSpeed;
    }

    /**
     * Method that sets the number of nitro cans in the car
     * <br>Precondition: none
     * <br>Postcondition: sets the number of nitro cans in the car as an int
     * @param newNumnitro: new number of nitro cans in the Car
     */
    public void setNitroCans(int newNumnitro)
    {
        nitroCans = newNumnitro;
    }

    /**
     * Method that sets the ID of the car
     * <br>Precondition: none
     * <br>Postcondition: sets the ID of the car as an int
     * @param newCarID: new ID of the Car
     */
    public void setCarID(int newCarID)
    {
        carID = newCarID;
    }

    //3 other mutator methods for object interaction
    /**
     * Method that runs when the car uses nitro
     * <br>Precondition: none
     * <br>Postcondition: decreases nitroCans by one and increases
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
     * <br>Postcondition: increases laps by one and decreases
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
     * <br>Postcondition: increases nitroCans by one and decreases
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
     * <br>Postconditions: either slows down or speeds up the car by 5 depending
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