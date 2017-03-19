package com.engineeringeric.parkerapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class LandingActivity extends AppCompatActivity {

    private BottomNavigationView navMenu;
    private FragmentManager fragmentManager;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        fragmentManager = getSupportFragmentManager();
        final Globals g = (Globals) getApplication();
        navMenu = (BottomNavigationView) findViewById(R.id.navMenu);
        navMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navProfile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.navSpots:
                        fragment = new SpotsFragment();
                        break;
                    case R.id.navMap:
                        fragment = new MapFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content_container, fragment).commit();
                return true;
            }
        });

        // Set default tab
        View defaultTab = navMenu.findViewById(R.id.navMap);
        defaultTab.performClick();
    }
}
