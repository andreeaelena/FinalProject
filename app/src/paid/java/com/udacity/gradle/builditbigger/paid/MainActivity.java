package com.udacity.gradle.builditbigger.paid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.andreea.joke_ui.JokeActivity;
import com.udacity.gradle.builditbigger.JokeRequestCallback;
import com.udacity.gradle.builditbigger.JokesEndpointAsyncTask;
import com.udacity.gradle.builditbigger.R;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressView = findViewById(R.id.progress_view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        mProgressView.setVisibility(View.VISIBLE);

        new JokesEndpointAsyncTask(new JokeRequestCallback() {
            @Override
            public void onResponse(final String joke) {
                mProgressView.setVisibility(View.GONE);

                // Launch the JokeActivity:
                launchJokeActivity(joke);
            }
        }).execute();
    }

    private void launchJokeActivity(String joke) {
        Intent jokeIntent = new Intent(getApplicationContext(), JokeActivity.class);
        if (!TextUtils.isEmpty(joke)) {
            jokeIntent.putExtra(JokeActivity.JOKE_TEXT_EXTRA, joke);
        }
        startActivity(jokeIntent);
    }
}
