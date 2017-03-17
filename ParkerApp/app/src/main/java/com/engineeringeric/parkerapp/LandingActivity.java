package com.engineeringeric.parkerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        final Globals g = (Globals) getApplication();
        final TextView tvWelcome = (TextView) findViewById(R.id.tvWelcome);

        tvWelcome.setText("Welcome "+ g.getFirstName() + " " + g.getLastName() + "!");

    }
}
