package com.andreea.bakingapp.joke_lib;

import java.util.Random;

/**
 * Utils class
 */
public class Utils {

    /**
     * Returns a random number between a min and max value.
     */
    public static int getRandomNumber(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
