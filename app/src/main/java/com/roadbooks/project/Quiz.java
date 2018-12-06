package com.roadbooks.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Quiz extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        Intent i = new Intent(this, CustomService.class);
        startService(i);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNav.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_assign:
                        Intent intent1 = new Intent(Quiz.this, Review.class);
                        Quiz.this.startActivity(intent1);
                        break;
                    case R.id.nav_quiz:
                        break;
                    case R.id.nav_grades:
                        Intent intent2 = new Intent(Quiz.this, Grades.class);
                        Quiz.this.startActivity(intent2);
                        break;

                }
                return false;
            }
        });


    }

//    private void startQuiz() {
//        Intent intent = new Intent(Quiz.this, QuizActivity.class);
//        startActivityForResult(intent, REQUEST_CODE_QUIZ);
//
//    }

    public void onClick3 (View v){
        Intent i = null, chooser = null;
        if(v.getId() == R.id.emergency){
            i = new Intent( Quiz.this, EmerQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if(v.getId() == R.id.parking){
            i = new Intent( Quiz.this, ParkingQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if(v.getId() == R.id.violation){
            i = new Intent( Quiz.this, ViolationsQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if(v.getId() == R.id.random){
            i = new Intent( Quiz.this, RandomQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if(v.getId() == R.id.signs){
            i = new Intent( Quiz.this, SignsQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if(v.getId() == R.id.positions){
            i = new Intent( Quiz.this, RoadQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if(v.getId() == R.id.genknow){
            i = new Intent( Quiz.this, QuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if(v.getId() == R.id.handling){
            i = new Intent( Quiz.this, HandlingQuizActivity.class);
            Quiz.this.startActivity(i);
        }



    }

}