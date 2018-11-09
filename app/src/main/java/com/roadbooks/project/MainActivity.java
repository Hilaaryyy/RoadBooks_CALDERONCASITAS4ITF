package com.roadbooks.project;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, CustomService.class);
        startService(i);
    }

    public void onClick (View v){
        Intent i = null, chooser = null;
        if(v.getId() == R.id.review){
            i = new Intent( MainActivity.this, Review.class);
            MainActivity.this.startActivity(i);
        }
        else if(v.getId() == R.id.quiz){
            i = new Intent( MainActivity.this, Quiz.class);
            MainActivity.this.startActivity(i);
        }
        else if(v.getId() == R.id.grades){
            i = new Intent( MainActivity.this, Grades.class);
            MainActivity.this.startActivity(i);
        }

    }

}
