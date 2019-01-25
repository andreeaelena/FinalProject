package com.andreea.bakingapp.joke_lib;

public class JokeProvider {

    private static final String[] JOKES = {
            "Q: Where do cows go for entertainment?\nA: The mooooo-vies!",
            "Q: What did one firefly say to the other?\nA: You glow, girl!",
            "Q: Why couldn't the pony sing?\nA: Because she was a little hoarse.",
            "Q: What creature is smarter than a talking parrot?\nA: A spelling bee.",
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

    public String getRandomJoke() {
        int jokePosition = Utils.getRandomNumber(0, JOKES.length - 1);
        return JOKES[jokePosition];
    }
}
