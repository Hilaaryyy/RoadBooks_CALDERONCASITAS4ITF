package com.roadbooks.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Quiz extends AppCompatActivity {
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
}
