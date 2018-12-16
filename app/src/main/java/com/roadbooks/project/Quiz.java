package com.roadbooks.project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;
    private RadioButton b1;
    private RadioButton b2;
    private RadioButton b3;
    private RadioButton b4;
    private RadioButton b5;
    private RadioButton b6;
    private RadioButton b7;
    private RadioButton b8;
    private Button start;
    private boolean answered;
    private RadioGroup rbGroup;
    private RadioGroup rbGroup2;


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
        rbGroup = findViewById(R.id.rbGroup1);
        rbGroup2 = findViewById(R.id.rbGroup2);
        b1 = findViewById(R.id.signs);
        b2 = findViewById(R.id.genknow);
        b3 = findViewById(R.id.violation);
        b4 = findViewById(R.id.handling);
        b5 = findViewById(R.id.positions);
        b6 = findViewById(R.id.parking);
        b7 = findViewById(R.id.emergency);
        b8 = findViewById(R.id.random);
        start = findViewById(R.id.start);

        Drawable d = getResources().getDrawable(R.drawable.rounded_button);
        Drawable dd = getResources().getDrawable(R.drawable.yellow);

        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                if(b1.isChecked())
                {
                    // Changing radio button 1 color on checked.
                    b1.setBackgroundDrawable(dd);

                    //Changing other remaining radio button color to black.
                    b2.setBackgroundDrawable(d);
                    b3.setBackgroundDrawable(d);
                    b4.setBackgroundDrawable(d);
                    b5.setBackgroundDrawable(d);
                    b6.setBackgroundDrawable(d);
                    b7.setBackgroundDrawable(d);
                    b8.setBackgroundDrawable(d);
                }

                if(b2.isChecked())
                {
                    // Changing radio button 2 color on checked.
                    b2.setBackgroundDrawable(dd);

                    //Changing other remaining radio button color to black.
                    b1.setBackgroundDrawable(d);
                    b3.setBackgroundDrawable(d);
                    b4.setBackgroundDrawable(d);
                    b5.setBackgroundDrawable(d);
                    b6.setBackgroundDrawable(d);
                    b7.setBackgroundDrawable(d);
                    b8.setBackgroundDrawable(d);
                }

                if(b3.isChecked())
                {
                    // Changing radio button 2 color on checked.
                    b3.setBackgroundDrawable(dd);

                    //Changing other remaining radio button color to black.
                    b1.setBackgroundDrawable(d);
                    b2.setBackgroundDrawable(d);
                    b4.setBackgroundDrawable(d);
                    b5.setBackgroundDrawable(d);
                    b6.setBackgroundDrawable(d);
                    b7.setBackgroundDrawable(d);
                    b8.setBackgroundDrawable(d);
                }

                if(b4.isChecked())
                {
                    // Changing radio button 2 color on checked.
                    b4.setBackgroundDrawable(dd);

                    //Changing other remaining radio button color to black.
                    b1.setBackgroundDrawable(d);
                    b3.setBackgroundDrawable(d);
                    b2.setBackgroundDrawable(d);
                    b5.setBackgroundDrawable(d);
                    b6.setBackgroundDrawable(d);
                    b7.setBackgroundDrawable(d);
                    b8.setBackgroundDrawable(d);
                }

            }
        });

        rbGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                if(b5.isChecked())
                {
                    // Changing radio button 1 color on checked.
                    b5.setBackgroundDrawable(dd);

                    //Changing other remaining radio button color to black.
                    b2.setBackgroundDrawable(d);
                    b3.setBackgroundDrawable(d);
                    b4.setBackgroundDrawable(d);
                    b1.setBackgroundDrawable(d);
                    b6.setBackgroundDrawable(d);
                    b7.setBackgroundDrawable(d);
                    b8.setBackgroundDrawable(d);
                }

                if(b6.isChecked())
                {
                    // Changing radio button 2 color on checked.
                    b6.setBackgroundDrawable(dd);

                    //Changing other remaining radio button color to black.
                    b1.setBackgroundDrawable(d);
                    b3.setBackgroundDrawable(d);
                    b4.setBackgroundDrawable(d);
                    b5.setBackgroundDrawable(d);
                    b2.setBackgroundDrawable(d);
                    b7.setBackgroundDrawable(d);
                    b8.setBackgroundDrawable(d);
                }

                if(b7.isChecked())
                {
                    // Changing radio button 2 color on checked.
                    b7.setBackgroundDrawable(dd);

                    //Changing other remaining radio button color to black.
                    b1.setBackgroundDrawable(d);
                    b2.setBackgroundDrawable(d);
                    b4.setBackgroundDrawable(d);
                    b5.setBackgroundDrawable(d);
                    b6.setBackgroundDrawable(d);
                    b3.setBackgroundDrawable(d);
                    b8.setBackgroundDrawable(d);
                }

                if(b8.isChecked())
                {
                    // Changing radio button 2 color on checked.
                    b8.setBackgroundDrawable(dd);

                    //Changing other remaining radio button color to black.
                    b1.setBackgroundDrawable(d);
                    b3.setBackgroundDrawable(d);
                    b2.setBackgroundDrawable(d);
                    b5.setBackgroundDrawable(d);
                    b6.setBackgroundDrawable(d);
                    b7.setBackgroundDrawable(d);
                    b4.setBackgroundDrawable(d);
                }

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered ){
                    if (b1.isChecked() || b2.isChecked() || b3.isChecked() || b4.isChecked()
                            || b5.isChecked() || b6.isChecked() || b7.isChecked() || b8.isChecked()){
                        checkAnswer();
                    } else {
                        Toast.makeText(Quiz.this, "Please select a category", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    private void checkAnswer(){
        answered = true;
        Intent i = null, chooser = null;
        if (b1.isChecked()){
            i = new Intent( Quiz.this, SignsQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if (b2.isChecked()){
            i = new Intent( Quiz.this, QuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if (b3.isChecked()){
            i = new Intent( Quiz.this, ViolationsQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if (b4.isChecked()){
            i = new Intent( Quiz.this, HandlingQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if (b5.isChecked()){
            i = new Intent( Quiz.this, RoadQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if (b6.isChecked()){
            i = new Intent( Quiz.this, ParkingQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if (b7.isChecked()){
            i = new Intent( Quiz.this, EmerQuizActivity.class);
            Quiz.this.startActivity(i);
        }
        if (b8.isChecked()){
            i = new Intent( Quiz.this, RandomQuizActivity.class);
            Quiz.this.startActivity(i);
        }
    }


//    public void onClick3 (View v){
//        Intent i = null, chooser = null;
//        if(v.getId() == R.id.emergency){
//            i = new Intent( Quiz.this, EmerQuizActivity.class);
//            Quiz.this.startActivity(i);
//        }
//        if(v.getId() == R.id.parking){
//            i = new Intent( Quiz.this, ParkingQuizActivity.class);
//            Quiz.this.startActivity(i);
//        }
//        if(v.getId() == R.id.violation){
//            i = new Intent( Quiz.this, ViolationsQuizActivity.class);
//            Quiz.this.startActivity(i);
//        }
//        if(v.getId() == R.id.random){
//            i = new Intent( Quiz.this, RandomQuizActivity.class);
//            Quiz.this.startActivity(i);
//        }
//        if(v.getId() == R.id.signs){
//            i = new Intent( Quiz.this, SignsQuizActivity.class);
//            Quiz.this.startActivity(i);
//        }
//        if(v.getId() == R.id.positions){
//            i = new Intent( Quiz.this, RoadQuizActivity.class);
//            Quiz.this.startActivity(i);
//        }
//        if(v.getId() == R.id.genknow){
//            i = new Intent( Quiz.this, QuizActivity.class);
//            Quiz.this.startActivity(i);
//        }
//        if(v.getId() == R.id.handling){
//            i = new Intent( Quiz.this, HandlingQuizActivity.class);
//            Quiz.this.startActivity(i);
//        }
//    }



}