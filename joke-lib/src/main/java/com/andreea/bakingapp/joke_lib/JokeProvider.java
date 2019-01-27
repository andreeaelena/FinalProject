package com.andreea.bakingapp.joke_lib;

/**
 * Class that provides random jokes from an internal hardcoded array.
 */
public class JokeProvider {

    /**
     * NOTE: the jokes can easily be stored in a separate JSON file or even inside a database,
     * but as a proof of concept, a String array did the job.
     */
    private static final String[] JOKES = {
            "Q: What does a spider’s bride wear?\nA: A webbing dress.",
            "Q: Where do cows go for entertainment?\nA: The mooooo-vies!",
            "Q: What did one firefly say to the other?\nA: You glow, girl!",
            "Q: Why couldn't the pony sing?\nA: Because she was a little hoarse.",
            "Q: What creature is smarter than a talking parrot?\nA: A spelling bee.",
            "Q: Where does the chicken like to eat?\nA: At a rooster-ant!",
            "Q: Where do you learn to make banana splits?\nA: At sundae school.",
            "Q: Why did the melon jump into the lake?\nA: It wanted to be a water-melon.",
            "Q: Why did the cookie go to the doctor?\nA: It was feeling crumb-y",
            "Q: Why did the banana go to the hospital?\nA: He was peeling really bad.",
            "Q: How does the ocean say hello?\nA: It waves.",
            "Q: What's the worst thing about throwing a party in space?\nA: You have to planet."
    };

    private static JokeProvider sInstance;

    private JokeProvider() {
        // Default private constructor
    }

    public static JokeProvider getInstance() {
        if (sInstance == null) {
            sInstance = new JokeProvider();
        }
        return sInstance;
    }

    /**
     * Returns a random joke as String.
     */
    public String getRandomJoke() {
        int jokePosition = Utils.getRandomNumber(0, JOKES.length - 1);
        return JOKES[jokePosition];
    }
}
