package com.roadbooks.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

public class Review extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        Intent i = new Intent(this, CustomService.class);
        startService(i);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_assign:
                        break;
                    case R.id.nav_quiz:
                        Intent intent1 = new Intent(Review.this, Quiz.class);
                        Review.this.startActivity(intent1);
                        break;
                    case R.id.nav_grades:
                        Intent intent2 = new Intent(Review.this, Grades.class);
                        Review.this.startActivity(intent2);
                        break;

                }
                return false;
            }
        });

        }
    public void onClick1 (View v){
        Intent i = null, chooser = null;
        if(v.getId() == R.id.emergency){
            i = new Intent( Review.this, emergencies.class);
            Review.this.startActivity(i);
        }
        if(v.getId() == R.id.parking){
            i = new Intent( Review.this, Parking.class);
            Review.this.startActivity(i);
        }
        if(v.getId() == R.id.violation){
            i = new Intent( Review.this, Violations.class);
            Review.this.startActivity(i);
        }
        if(v.getId() == R.id.random){
            i = new Intent( Review.this, Handling.class);
            Review.this.startActivity(i);
        }
        if(v.getId() == R.id.signs){
            i = new Intent( Review.this, Signs.class);
            Review.this.startActivity(i);
        }
        if(v.getId() == R.id.positions){
            i = new Intent( Review.this, Positions.class);
            Review.this.startActivity(i);
        }
        if(v.getId() == R.id.genknow){
            i = new Intent( Review.this, GenKnow.class);
            Review.this.startActivity(i);
        }




    }

        }


