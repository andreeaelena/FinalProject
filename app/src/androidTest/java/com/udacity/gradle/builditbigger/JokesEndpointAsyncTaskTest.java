package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class JokesEndpointAsyncTaskTest {

    @Test
    public void jokesEndpointAsyncTaskShouldReturnNonEmptyString() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);

        // Execute the AsyncTask
        new JokesEndpointAsyncTask(new JokeRequestCallback() {
            @Override
            public void onResponse(String joke) {
                assertNotEquals(joke, "");
                signal.countDown(); // Notify the CountDownLatch
            }
        }).execute();

        signal.await(); // Wait for the AsyncTask to finish
    }

    @Test
    public void jokesEndpointAsyncTaskShouldReturnNonNullString() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);

        // Execute the AsyncTask
        new JokesEndpointAsyncTask(new JokeRequestCallback() {
            @Override
            public void onResponse(String joke) {
                assertNotNull(joke);
                signal.countDown(); // Notify the CountDownLatch
            }
        }).execute();

        signal.await(); // Wait for the AsyncTask to finish
    }
}