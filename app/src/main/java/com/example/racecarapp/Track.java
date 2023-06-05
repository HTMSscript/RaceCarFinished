package com.example.racecarapp;


//javadoc description

import android.view.View;

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
    private final Car playerRacer;
    /**
     * npc racer on the track
     */
    private final Car aiRacer;
    /**
     * printed text
     */
    private static String trackTxt;

    public static void setTrackTxt(String str) {
        trackTxt = str;
    }


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
        playerRacer.setNitroCans(2);
        aiRacer.setLaps(1);
        aiRacer.setCurrentSpeed(0);
        aiRacer.setNitroCans(2);

        MainActivity.getIvFin().setVisibility(View.INVISIBLE);
        MainActivity.getIvMon().setVisibility(View.VISIBLE);
        MainActivity.btnSetInvis(MainActivity.getBtnOpt1());
        MainActivity.btnSetInvis(MainActivity.getBtnOpt2());

        //intro to game
        trackTxt = "Welcome to " + name + ". Today we will be pitting you, the " + playerRacer.getBrand() + ", against your opponent, the " + aiRacer.getBrand() + "!";
        MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
        MainActivity.btnSetVis(MainActivity.getBtnOpt3());
        MainActivity.btnSetText(MainActivity.getBtnOpt3(), "Continue");
        MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerStart();
                aiStart();
            }
        });

    }


    private void laps() {
        if(playerRacer.getCurrentSpeed() > lapLength && playerRacer.getLaps() < numLaps)
        {
            playerRacer.lap();
            trackTxt += "\nYou completed a lap! You are on lap " + playerRacer.getLaps() + "/" + numLaps;
            MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
        }
        if(aiRacer.getCurrentSpeed() > lapLength && aiRacer.getLaps() < numLaps)
        {
            aiRacer.lap();
            trackTxt += "\nYour opponent completed a lap! They are on lap " + aiRacer.getLaps() + "/" + numLaps;
            MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
        }
        MainActivity.btnSetInvis(MainActivity.getBtnOpt1());
        MainActivity.btnSetInvis(MainActivity.getBtnOpt2());

        MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerRacer.getLaps() == numLaps || aiRacer.getLaps() == numLaps) {
                    wins();
                }
                else {
                    playerRace();
                }
            }
        });
    }

    private void wins() {
        MainActivity.getIvDri().setVisibility(View.INVISIBLE);
        MainActivity.getIvNit().setVisibility(View.INVISIBLE);
        MainActivity.getIvPit().setVisibility(View.INVISIBLE);
        MainActivity.getIvFin().setVisibility(View.VISIBLE);
        //if statements determining who wins
        if (playerRacer.getLaps() > aiRacer.getLaps())
        {
            trackTxt = "\nYou race across the finish line ahead of your opponent! Congratulations you have won the race!!";
            MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
            MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playAgain();
                }
            });
        }
        else if (playerRacer.getLaps() < aiRacer.getLaps())
        {
            trackTxt = "\nYour opponent races across the finish line ahead of you! Sadly, you have lost the race!!";
            MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
            MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playAgain();
                }
            });
        }
        else
        {
            //if laps are reached at the same time, speed is tiebreaker
            if (playerRacer.getCurrentSpeed() > aiRacer.getCurrentSpeed())
            {
                trackTxt = "\nIt's a photo finish... \nThe " + playerRacer.getBrand() + " has it!! Congratulations!";
                MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
                MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playAgain();
                    }
                });
            }
            else
            {
                trackTxt = "\nIt's a photo finish... \nThe " + aiRacer.getBrand() + " has it!! Tough Break!";
                MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
                MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playAgain();
                    }
                });
            }
        }
    }

    private void playAgain() {
        MainActivity.btnSetInvis(MainActivity.getBtnOpt3());
        MainActivity.btnSetVis(MainActivity.getBtnOpt1());
        MainActivity.btnSetVis(MainActivity.getBtnOpt2());
        MainActivity.btnSetText(MainActivity.getBtnOpt1(), "Yes");
        MainActivity.btnSetText(MainActivity.getBtnOpt2(), "No");

        trackTxt = "Do you want to play again?";
        MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
        MainActivity.getBtnOpt1().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                race();
            }
        });
        MainActivity.getBtnOpt2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }


    //private method to support public method
    /**
     * Method that runs when the player controlled car starts the race
     * <br>Preconditions: none
     * <br>Postconditions: runs the methods useNitro or sets current speed
     *    to 7.5 depending on user input
     */

    private void playerStart() {
        MainActivity.getIvMon().setVisibility(View.INVISIBLE);
        MainActivity.getIvSta().setVisibility(View.VISIBLE);

        trackTxt = "3... 2... 1.. GO!\nDo you start the race with or without Nitro?";
        MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
        MainActivity.btnSetVis(MainActivity.getBtnOpt1());
        MainActivity.btnSetVis(MainActivity.getBtnOpt2());
        MainActivity.btnSetInvis(MainActivity.getBtnOpt3());


        MainActivity.btnSetText(MainActivity.getBtnOpt1(), "With Nitro");
        MainActivity.btnSetText(MainActivity.getBtnOpt2(), "Without Nitro");

        MainActivity.getBtnOpt1().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getIvSta().setVisibility(View.INVISIBLE);
                MainActivity.getIvNit().setVisibility(View.VISIBLE);
                trackTxt = "You used Nitro! You zoom ahead.";
                MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
                playerRacer.useNitro();
                MainActivity.btnSetVis(MainActivity.getBtnOpt3());
                MainActivity.btnSetInvis(MainActivity.getBtnOpt1());
                MainActivity.btnSetInvis(MainActivity.getBtnOpt2());
                MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playerRace();
                    }
                });
            }
        });

        MainActivity.getBtnOpt2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getIvSta().setVisibility(View.INVISIBLE);
                MainActivity.getIvDri().setVisibility(View.VISIBLE);
                trackTxt = "You chose the slow start, but saved a canister for later.";
                MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
                playerRacer.setCurrentSpeed(7.5);
                MainActivity.btnSetVis(MainActivity.getBtnOpt3());
                MainActivity.btnSetInvis(MainActivity.getBtnOpt1());
                MainActivity.btnSetInvis(MainActivity.getBtnOpt2());

                MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playerRace();
                    }
                });
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
            trackTxt += "\nYour opponent used nitro!";
            MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
            aiRacer.useNitro();
        }
        else
        {
            trackTxt += "\nYour opponent accelerated normally.";
            MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
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
    private void playerRace()
    {
        trackTxt = "\nThe race is on! Would you like to pit stop, use a nitro can, or continue driving?";
        MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
        MainActivity.btnSetText(MainActivity.getBtnOpt1(), "Pit Stop");
        MainActivity.btnSetText(MainActivity.getBtnOpt2(), "Use Nitro");
        MainActivity.btnSetVis(MainActivity.getBtnOpt2());
        MainActivity.btnSetVis(MainActivity.getBtnOpt1());

        MainActivity.getBtnOpt1().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getIvDri().setVisibility(View.INVISIBLE);
                MainActivity.getIvNit().setVisibility(View.INVISIBLE);
                MainActivity.getIvPit().setVisibility(View.VISIBLE);
                playerRacer.pitStop();
                trackTxt = "You take a pit stop, slowing down but adding more nitro cans!";
                MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
                aiRace();
                laps();
            }
        });

        MainActivity.getBtnOpt2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getIvDri().setVisibility(View.INVISIBLE);
                MainActivity.getIvNit().setVisibility(View.VISIBLE);
                MainActivity.getIvPit().setVisibility(View.INVISIBLE);
                trackTxt = "You use your nitro, flying forward and increasing your speed!";
                MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
                playerRacer.useNitro();
                aiRace();
                laps();
            }
        });

        MainActivity.getBtnOpt3().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getIvDri().setVisibility(View.VISIBLE);
                MainActivity.getIvNit().setVisibility(View.INVISIBLE);
                MainActivity.getIvPit().setVisibility(View.INVISIBLE);
                playerRacer.drive();
                aiRace();
                laps();
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
            trackTxt += "\nYour opponent went into the pit!";
            MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
        }
        else if (rand == 1)
        {
            aiRacer.useNitro();
            trackTxt += "\nYour opponent used nitro!";
            MainActivity.tvSetText(MainActivity.getTvDesc(), trackTxt);
        }
        else
        {
            aiRacer.drive();
        }
    }

}