package com.andreea.joke_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_TEXT_EXTRA = "joke_text_extra";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = findViewById(R.id.joke_text_view);

        if (getIntent().hasExtra(JOKE_TEXT_EXTRA)) {
            String jokeText = getIntent().getStringExtra(JOKE_TEXT_EXTRA);
            jokeTextView.setText(jokeText);
        }
    }
}
