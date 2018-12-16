package com.roadbooks.project;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class HandlingQuizActivity extends AppCompatActivity {
    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 30000;


    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;


    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handling_quiz);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        Menu menu = bottomNav.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_assign:
                        Intent intent1 = new Intent(HandlingQuizActivity.this, Review.class);
                        HandlingQuizActivity.this.startActivity(intent1);
                        break;
                    case R.id.nav_quiz:
                        break;
                    case R.id.nav_grades:
                        Intent intent2 = new Intent(HandlingQuizActivity.this, Grades.class);
                        HandlingQuizActivity.this.startActivity(intent2);
                        break;

                }
                return false;
            }
        });

        textViewQuestion = findViewById(R.id.text_view_question);
        textViewScore = findViewById(R.id.text_view_score);
        textViewQuestionCount = findViewById(R.id.text_view_question_count);
        textViewCountDown = findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.handlinggetAllQuestions();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered ){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()){
                        checkAnswer();
                    } else {
                        Toast.makeText(HandlingQuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else{
                    showNextQuestion();
                }
            }
        });

        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb1.isChecked()) {
                    rb1.setBackgroundColor(Color.parseColor("#F1CD13"));
                    rb2.setBackgroundColor(Color.parseColor("#3b3b3b"));
                    rb3.setBackgroundColor(Color.parseColor("#3b3b3b"));
                }
                if (rb2.isChecked()) {
                    rb1.setBackgroundColor(Color.parseColor("#3b3b3b"));
                    rb2.setBackgroundColor(Color.parseColor("#F1CD13"));
                    rb3.setBackgroundColor(Color.parseColor("#3b3b3b"));
                }
                if (rb3.isChecked()) {
                    rb1.setBackgroundColor(Color.parseColor("#3b3b3b"));
                    rb2.setBackgroundColor(Color.parseColor("#3b3b3b"));
                    rb3.setBackgroundColor(Color.parseColor("#F1CD13"));
                }

            }
        });
    }

    //finish na
    private void showNextQuestion(){
        rb1.setBackgroundColor(Color.parseColor("#3b3b3b"));
        rb2.setBackgroundColor(Color.parseColor("#3b3b3b"));
        rb3.setBackgroundColor(Color.parseColor("#3b3b3b"));
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal){
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());

            questionCounter++;
            textViewQuestionCount.setText("Question " + questionCounter + " of " + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();

        } else {
            finishQuiz();
        }
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int)(timeLeftInMillis / 1000) / 60;
        int seconds = (int)(timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis < 10000){
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }
    }

    private void checkAnswer(){
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNr()){
            score++;
            textViewScore.setText("Score: 0" + score);
        }
        showSolution();
    }

    private void showSolution(){
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
//        rb1.setBackgroundColor(Color.parseColor("#E81616"));
//        rb2.setBackgroundColor(Color.parseColor("#E81616"));
//        rb3.setBackgroundColor(Color.parseColor("#E81616"));
//        text.setText(currentQuestion.getExplain());

        switch(currentQuestion.getAnswerNr()){
            case 1:
                rbSelected.setBackgroundColor(Color.parseColor("#E81616"));
                rb1.setBackgroundColor(Color.parseColor("#7CCF4E"));

                Toast.makeText(this, "The correct answer is A", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                rbSelected.setBackgroundColor(Color.parseColor("#E81616"));
                rb2.setBackgroundColor(Color.parseColor("#7CCF4E"));
//                textViewQuestion.setText("B is correct!");
                Toast.makeText(this, "The correct answer is B", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                rbSelected.setBackgroundColor(Color.parseColor("#E81616"));
                rb3.setBackgroundColor(Color.parseColor("#7CCF4E"));
//                textViewQuestion.setText("C is correct!");
                Toast.makeText(this, "The correct answer is C", Toast.LENGTH_SHORT).show();
                break;

        }
        if (questionCounter < questionCountTotal){
            buttonConfirmNext.setText("Next");
        } else{
            buttonConfirmNext.setText("Finish");
        }
    }

    private void finishQuiz(){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            finishQuiz();
        } else {
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }



}


