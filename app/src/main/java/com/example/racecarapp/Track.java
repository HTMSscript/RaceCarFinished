package com.example.racecarapp;


//javadoc description

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

/**
 * This is a template to create tracks for the cars to race on
 * @author Luke Porter
 * @version 0.5
 */
public class Track {

    /**
     * length of each lap
     */
    private final int lapLength;
    /**
     * number of laps on each track
     */
    private final int numLaps;
    /**
     * name of track
     */
    private final String name;

    //at least two instance variables of type YourClass
    /**
     * player-controlled racer on the track
     */
    private Car playerRacer;
    /**
     * npc racer on the track
     */
    private Car aiRacer;
    /**
     * printed text
     */
    private String trackTxt;

    Button btn1 = MainActivity.getBtnOpt1();
    Button btn2 = MainActivity.getBtnOpt2();
    Button btn3 = MainActivity.getBtnOpt3();

    //constructors
    /**
     * Constructor that initializes the player and ai racer
     * <br>Preconditions: playerRacer and aiRacer exists
     * <br>Postconditions: creates a Track object with playerRacer
     *    "playerRacer", aiRacer "aiRacer", lapLength of 20, numLaps 5, and the
     *    name "Monaco"
     * @param playerRacer: player-controlled racer
     * @param aiRacer: npc racer
     */
    public Track(Car playerRacer, Car aiRacer)
    {
        this.lapLength = 20;
        this.numLaps = 5;
        this.playerRacer = playerRacer;
        this.aiRacer = aiRacer;
        this.name = "Monaco";
    }
    /**
     * Constructor that initializes the player, number of laps, and ai racer
     * <br>Preconditions: playerRacer and aiRacer exists
     * <br>Postconditions: creates a Track object with playerRacer
     *    "playerRacer", aiRacer "aiRacer", lapLength of 20, numLaps "numLaps",
     *    and the name "Bahrain"
     * @param playerRacer: player-controlled racer
     * @param aiRacer: npc racer
     * @param numLaps: number of laps
     */
    public Track(int numLaps, Car playerRacer, Car aiRacer)
    {
        this.lapLength = 20;
        this.numLaps = numLaps;
        this.playerRacer = playerRacer;
        this.aiRacer = aiRacer;
        this.name = "Bahrain";
    }

    public String getTrackTxt() {
        return trackTxt;
    }

    //toString method
    /**
     * Method that prints a track instance as a String
     * <br>Preconditions: Track object exists
     * <br>Postconditions: Prints name, number of laps, and first and second
     *    racer on the track.
     */
    @NonNull
    public String toString()
    {
        return "Name:\t\t  " + name +
                "\nNumber of Laps: " + numLaps +
                "\nFirst Racer:  " + playerRacer.getBrand() +
                "\nSecond Racer: " + aiRacer.getBrand();
    }

    /**
     * Method that runs when the cars race
     * <br>Preconditions: none
     * <br>Postconditions: determines a winner of the race by calling methods, playerStart(), playerRace(), aiStart(), and aiRace(), and tracking the number of laps each car completes
     */
    public void race()
    {
        //set both racers laps to 1 and speed to 0
        playerRacer.setLaps(1);
        playerRacer.setCurrentSpeed(0);
        aiRacer.setLaps(1);
        aiRacer.setCurrentSpeed(0);

        //intro to game
        trackTxt = "Welcome to " + name + ". Today we will be pitting you, the " + playerRacer.getBrand() + ", against your opponent, the " + aiRacer.getBrand() + "!";
        playerStart(btn1, btn2);
        aiStart();

        //simulation loop
        while (playerRacer.getLaps() < numLaps && aiRacer.getLaps() < numLaps)
        {

            playerRace(btn1,btn2,btn3);
            aiRace();
            if(playerRacer.getCurrentSpeed() > lapLength && playerRacer.getLaps() < numLaps)
            {
                playerRacer.lap();
                trackTxt = "You completed a lap! You are on lap " + playerRacer.getLaps() + "/" + numLaps;
            }
            if(aiRacer.getCurrentSpeed() > lapLength && aiRacer.getLaps() < numLaps)
            {
                aiRacer.lap();
                trackTxt = "Your opponent completed a lap! They are on lap " + aiRacer.getLaps() + "/" + numLaps;
            }
        }
        //if statements determining who wins
        if (playerRacer.getLaps() > aiRacer.getLaps())
        {
            trackTxt = "\nYou race across the finish line ahead of your opponent! Congratulations you have won the race!!";
        }
        else if (playerRacer.getLaps() < aiRacer.getLaps())
        {
            trackTxt = "\nYour opponent races across the finish line ahead of you! Sadly, you have lost the race!!";
        }
        else
        {
            //if laps are reached at the same time, speed is tiebreaker
            if (playerRacer.getCurrentSpeed() > aiRacer.getCurrentSpeed())
            {
               trackTxt = "It's a photo finish... \n The " + playerRacer.getBrand() + " has it!! Congratulations!";
            }
            else
            {
                trackTxt = "It's a photo finish... \n The " + aiRacer.getBrand() + " has it!! Tough Break!";
            }
        }


    }


    //private method to support public method
    /**
     * Method that runs when the player controlled car starts the race
     * <br>Preconditions: none
     * <br>Postconditions: runs the methods useNitro or sets current speed
     *    to 7.5 depending on user input
     */

    private void playerStart(Button btn1, Button btn2)
    {

        trackTxt = "3... 2... 1.. GO!\nDo you start the race with (press 1) or without (press 2) Nitro?";

           btn1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   trackTxt = "You used Nitro! You zoom ahead.";
                   playerRacer.useNitro();
               }
           });

           btn2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   trackTxt = "You chose the slow start, but saved a canister for later.";
                   playerRacer.setCurrentSpeed(7.5);
               }
           });
    }

    /**
     * Method that runs when the nonplayer controlled car starts the race
     * <br>Preconditions: none
     * <br>Postconditions: either calls useNitro or sets current speed to
     *    7.5 based on a coin flip
     */
    private void aiStart()
    {
        int rand = (int) (2*Math.random());
        if (rand == 0)
        {
            trackTxt = "Your opponent used nitro!";
            aiRacer.useNitro();
        }
        else
        {
            trackTxt = "Your opponent accelerated normally.";
            aiRacer.setCurrentSpeed(7.5);
        }
    }
    /**
     * Method that runs during the race for the player's turn
     * <br>Preconditions: none
     * <br>Postconditions: either calls pitStop(), useNitro(), or drive()
     *    based on user input. If the user chooses an unavailable option,
     *    the game ends.
     */
    private void playerRace(Button btn1, Button btn2, Button btn3)
    {
        trackTxt = "\nThe race is on! Do you \n1. Take a pit stop \n2. Use nitro \n3. Continue driving";

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerRacer.pitStop();
                trackTxt = "You take a pit stop, slowing down but adding more nitro cans!";
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trackTxt = "You use your nitro, flying forward and increasing your speed!";
                playerRacer.useNitro();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerRacer.drive();
            }
        });

    }
    /**
     * Method that runs during the race for the npc turn
     * <br>Preconditions: none
     * <br>Postconditions: either calls pitStop(), useNitro(), or drive()
     *    based on a random chance and the number of available nitro cans
     */
    private void aiRace()
    {
        int rand = (int) (Math.random()*3);
        if (aiRacer.getNumNitroCans() == 0 || rand == 0)
        {
            aiRacer.pitStop();
            trackTxt = "Your opponent went into the pit!";
        }
        else if (rand == 1)
        {
            aiRacer.useNitro();
            trackTxt = "Your opponent used nitro!";
        }
        else
        {
            aiRacer.drive();
        }
    }

}