package com.udacity.gradle.builditbigger;

/**
 * Interface used as a callback to request a joke from the Google Cloud Endpoints module.
 */
public interface JokeRequestCallback {

    /**
     * Called when a joke is retrieved from the GCE module.
     */
    void onResponse(String joke);
}