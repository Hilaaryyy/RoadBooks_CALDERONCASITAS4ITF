package com.roadbooks.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Grades extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grades);
        Intent i = new Intent(this, CustomService.class);
        startService(i);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNav.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_assign:
                        Intent intent1 = new Intent(Grades.this, Review.class);
                        Grades.this.startActivity(intent1);
                        break;
                    case R.id.nav_quiz:
                        Intent intent2 = new Intent(Grades.this, Quiz.class);
                        Grades.this.startActivity(intent2);
                        break;
                    case R.id.nav_grades:
                        break;

                }
                return false;
            }
        });
    }
}
