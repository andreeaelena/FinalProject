package com.andreea.bakingapp.joke_lib;

public class JokeProvider {

    private static final String[] JOKES = {
            "Joke 1",
            "Joke 2",
            "Joke 3"
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
