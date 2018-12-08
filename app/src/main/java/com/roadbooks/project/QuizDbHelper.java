package com.roadbooks.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.roadbooks.project.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Quiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;
    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        //GENKNOW
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER " +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

        //EMER
        final String SQL_CREATE_EMERQUESTIONS_TABLE = "CREATE TABLE " +
                EmerQuestionsTable.EMERTABLE_NAME + " ( " +
                EmerQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                EmerQuestionsTable.EMERCOLUMN_QUESTION + " TEXT, " +
                EmerQuestionsTable.EMERCOLUMN_OPTION1 + " TEXT, " +
                EmerQuestionsTable.EMERCOLUMN_OPTION2 + " TEXT, " +
                EmerQuestionsTable.EMERCOLUMN_OPTION3 + " TEXT, " +
                EmerQuestionsTable.EMERCOLUMN_ANSWER_NR + " INTEGER " +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT" +
                ")";

        db.execSQL(SQL_CREATE_EMERQUESTIONS_TABLE);
        emerfillQuestionsTable();

        //SIGNS
        final String SQL_CREATE_SIGNSQUESTIONS_TABLE = "CREATE TABLE " +
                SignsQuestionsTable.SIGNSTABLE_NAME + " ( " +
                SignsQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SignsQuestionsTable.SIGNSCOLUMN_QUESTION + " TEXT, " +
                SignsQuestionsTable.SIGNSCOLUMN_OPTION1 + " TEXT, " +
                SignsQuestionsTable.SIGNSCOLUMN_OPTION2 + " TEXT, " +
                SignsQuestionsTable.SIGNSCOLUMN_OPTION3 + " TEXT, " +
                SignsQuestionsTable.SIGNSCOLUMN_ANSWER_NR + " INTEGER " +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT" +
                ")";

        db.execSQL(SQL_CREATE_SIGNSQUESTIONS_TABLE);
        signsfillQuestionsTable();

        //VIOLATIONS
        final String SQL_CREATE_VIOLATIONSQUESTIONS_TABLE = "CREATE TABLE " +
                ViolationsQuestionsTable.VIOLATIONSTABLE_NAME + " ( " +
                ViolationsQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ViolationsQuestionsTable.VIOLATIONSCOLUMN_QUESTION + " TEXT, " +
                ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION1 + " TEXT, " +
                ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION2 + " TEXT, " +
                ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION3 + " TEXT, " +
                ViolationsQuestionsTable.VIOLATIONSCOLUMN_ANSWER_NR + " INTEGER " +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT" +
                ")";

        db.execSQL(SQL_CREATE_VIOLATIONSQUESTIONS_TABLE);
        violationsfillQuestionsTable();

        //HANDLING
        final String SQL_CREATE_HANDLINGQUESTIONS_TABLE = "CREATE TABLE " +
                HandlingQuestionsTable.HANDLINGTABLE_NAME + " ( " +
                HandlingQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HandlingQuestionsTable.HANDLINGCOLUMN_QUESTION + " TEXT, " +
                HandlingQuestionsTable.HANDLINGCOLUMN_OPTION1 + " TEXT, " +
                HandlingQuestionsTable.HANDLINGCOLUMN_OPTION2 + " TEXT, " +
                HandlingQuestionsTable.HANDLINGCOLUMN_OPTION3 + " TEXT, " +
                HandlingQuestionsTable.HANDLINGCOLUMN_ANSWER_NR + " INTEGER " +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT" +
                ")";

        db.execSQL(SQL_CREATE_HANDLINGQUESTIONS_TABLE);
        handlingfillQuestionsTable();

        //ROAD
        final String SQL_CREATE_ROADQUESTIONS_TABLE = "CREATE TABLE " +
                RoadQuestionsTable.ROADTABLE_NAME + " ( " +
                RoadQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RoadQuestionsTable.ROADCOLUMN_QUESTION + " TEXT, " +
                RoadQuestionsTable.ROADCOLUMN_OPTION1 + " TEXT, " +
                RoadQuestionsTable.ROADCOLUMN_OPTION2 + " TEXT, " +
                RoadQuestionsTable.ROADCOLUMN_OPTION3 + " TEXT, " +
                RoadQuestionsTable.ROADCOLUMN_ANSWER_NR + " INTEGER " +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT" +
                ")";

        db.execSQL(SQL_CREATE_ROADQUESTIONS_TABLE);
        roadfillQuestionsTable();

        //PARKING
        final String SQL_CREATE_PARKINGQUESTIONS_TABLE = "CREATE TABLE " +
                ParkingQuestionsTable.PARKINGTABLE_NAME + " ( " +
                ParkingQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ParkingQuestionsTable.PARKINGCOLUMN_QUESTION + " TEXT, " +
                ParkingQuestionsTable.PARKINGCOLUMN_OPTION1 + " TEXT, " +
                ParkingQuestionsTable.PARKINGCOLUMN_OPTION2 + " TEXT, " +
                ParkingQuestionsTable.PARKINGCOLUMN_OPTION3 + " TEXT, " +
                ParkingQuestionsTable.PARKINGCOLUMN_ANSWER_NR + " INTEGER " +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT" +
                ")";

        db.execSQL(SQL_CREATE_PARKINGQUESTIONS_TABLE);
        parkingfillQuestionsTable();

        //RANDOM
        final String SQL_CREATE_RANDOMQUESTIONS_TABLE = "CREATE TABLE " +
                RandomQuestionsTable.RANDOMTABLE_NAME + " ( " +
                RandomQuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                RandomQuestionsTable.RANDOMCOLUMN_QUESTION + " TEXT, " +
                RandomQuestionsTable.RANDOMCOLUMN_OPTION1 + " TEXT, " +
                RandomQuestionsTable.RANDOMCOLUMN_OPTION2 + " TEXT, " +
                RandomQuestionsTable.RANDOMCOLUMN_OPTION3 + " TEXT, " +
                RandomQuestionsTable.RANDOMCOLUMN_ANSWER_NR + " INTEGER " +
//                QuestionsTable.COLUMN_EXPLAIN + "TEXT" +
                ")";

        db.execSQL(SQL_CREATE_RANDOMQUESTIONS_TABLE);
        randomfillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + EmerQuestionsTable.EMERTABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + SignsQuestionsTable.SIGNSTABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + ViolationsQuestionsTable.VIOLATIONSTABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + HandlingQuestionsTable.HANDLINGTABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + RoadQuestionsTable.ROADTABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + ParkingQuestionsTable.PARKINGTABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + RandomQuestionsTable.RANDOMTABLE_NAME);
        onCreate(db);

    }

    //EMER
    private void emerfillQuestionsTable() {
        Question q1 = new Question("What should you do in case your vehicle breaks down on an expressway?", "A. Open your trunk and hood" ,

                "B. Stand on the expressway and flag down passing drivers for help", "C. All of the above", 3);
        emeraddQuestion(q1);
        Question q2 = new Question("What should you do when an ambulance comes up behind you flashing red lights and/or sounding its siren?", "A. Stop as soon as you can" ,
                "B. Pull over to the right and slow down or even stop if necessary", "C. Speed up so that you don't hold the ambulances", 2);
        emeraddQuestion(q2);
        Question q3 = new Question("While driving the hood of your car lifts up blocking your vision. What should you do?",
                "A. Pull to the side of the road and refasten the hood", "B. All of the above", "C. Look through the gap underneath the hood or out of the side window", 2);
        emeraddQuestion(q3);
        Question q4 = new Question("What will happen when your rear tire blows out?",
                "A. The front end will pull towards the side of the blowout", "B. The back end will sway away from the blowout", "C. The back end will sway towards the side of the blowout", 2);
        emeraddQuestion(q4);

        Question q5 = new Question("What will happen when your front tire blows out?", "A. The front end will pull towards the side of the blowout", "B. The back end will sway away from the blowout", "C. The back end will sway towards the side of the blowout", 3);
        emeraddQuestion(q5);

        Question q6 = new Question("In case of an accident, the first duty of the driver involved is to:", "A. pick-up the injured person and take him to the nearest hospital", "B. report the accident to the nearest hospital", "C. report the accident to the nearest police station", 3);
        emeraddQuestion(q6);

        Question q7 = new Question("In case of injuries caused by an accident, the duty of the uninjured driver is to:", "A. call a physician", "B. keep the victim lying down", "C. try to determine who is at fault", 1);
        emeraddQuestion(q7);

        Question q8 = new Question("When a vehicle is stalled or disabled, the driver must park the vehicle on the shoulder of the road and:", "A. switch on the parking light", "B. install the early warning device", "C. switch on the parking light and install the Early Warning Device to the front and rear of the motor vehicle", 3);
        emeraddQuestion(q8);

        Question q9 = new Question("When a vehicle starts to skid, what should the driver do?", "A. Immediately step on the brakes ", "B. Hold firmly on to the wheel while slowing down the vehicle", "C. Turn the wheels to the opposite the direction of the skid ", 2);
        emeraddQuestion(q9);

        Question q10 = new Question("When a vehicle is on fire, what should the driver do?", "A. Drive onto a breakdown lane as quickly and safely as possible.' ", "B. Once you’re in a safe location, get everyone out of the vehicle and away from the fire. Warn bystanders to stay away as well.", "C. All of the above", 3);
        emeraddQuestion(q10);


    }
    private void emeraddQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(EmerQuestionsTable.EMERCOLUMN_QUESTION, question.getQuestion());
        cv.put(EmerQuestionsTable.EMERCOLUMN_OPTION1, question.getOption1());
        cv.put(EmerQuestionsTable.EMERCOLUMN_OPTION2, question.getOption2());
        cv.put(EmerQuestionsTable.EMERCOLUMN_OPTION3, question.getOption3());
        cv.put(EmerQuestionsTable.EMERCOLUMN_ANSWER_NR, question.getAnswerNr());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getExplain());
        db.insert(EmerQuestionsTable.EMERTABLE_NAME, null, cv);
    }

    public List<Question> emergetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + EmerQuestionsTable.EMERTABLE_NAME, null );


        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(EmerQuestionsTable.EMERCOLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(EmerQuestionsTable.EMERCOLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(EmerQuestionsTable.EMERCOLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(EmerQuestionsTable.EMERCOLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(EmerQuestionsTable.EMERCOLUMN_ANSWER_NR)));
//                question.setExplain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    //RANDOM
    private void randomfillQuestionsTable() {
        Question q1 = new Question("You are in a no-passing zone when the center of the road is marked by:",
                "A. a broken yellow line ", "B. a broken white line", "C. two solid yellow lines", 3);
        randomaddQuestion(q1);
        Question q2 = new Question("You are not allowed to cross a lane with continuous yellow line on the road except if you are:",
                "A. changing lanes" ,
                "B. turning right", "C. turning left", 3);
        randomaddQuestion(q2);
        Question q3 = new Question("How many days are given for you to settle the case to get your license back if you get caught?",
                "A. 15 days", "B. 30 days", "C. 10 days", 1);
        randomaddQuestion(q3);
        Question q4 = new Question("Control braking force to prevent the tyres from skidding under heavy braking or when braking in slippery conditions.  ",
                "A. Emergency brake assist ", "B. Traction control systems", "C. Antilock braking system ", 3);
        randomaddQuestion(q4);

        Question q5 = new Question("While driving, you should look at the side and rear view mirror:",
                "A. at least one second each", "B. not less than once per minute", "C. as quick as possible", 3);
        randomaddQuestion(q5);

        Question q6 = new Question("You are not allowed to overtake at the foot of a bridge because:",
                "A. the bridge is narrow", "B. it's dangerous and you cannot see oncoming vehicles", "C. people are crossing", 2);
        randomaddQuestion(q6);

        Question q7 = new Question("Ignoring traffic lights during late night could:",
                "A. make you a good driver ", "B. involve you in a fatal accident", "C. decrease your fuel consumption ", 2);
        randomaddQuestion(q7);

        Question q8 = new Question("What should you do in case your vehicle breaks down on an expressway?", "A. Open your trunk and hood" ,

                "B. Stand on the expressway and flag down passing drivers for help", "C. All of the above", 3);
        randomaddQuestion(q8);

        Question q9 = new Question("Parking lights may be used:",
                "A. at anytime", "B. for parking and when visibility is poor", "C. when driving on a well-lighted streets", 2);
        randomaddQuestion(q9);

        Question q10 = new Question("A good driving attitude of a driver is to:",
                "A. drive slowly ", "B. drive defensively", "C. take chances if possible", 2);
        randomaddQuestion(q10);


    }
    private void randomaddQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(RandomQuestionsTable.RANDOMCOLUMN_QUESTION, question.getQuestion());
        cv.put(RandomQuestionsTable.RANDOMCOLUMN_OPTION1, question.getOption1());
        cv.put(RandomQuestionsTable.RANDOMCOLUMN_OPTION2, question.getOption2());
        cv.put(RandomQuestionsTable.RANDOMCOLUMN_OPTION3, question.getOption3());
        cv.put(RandomQuestionsTable.RANDOMCOLUMN_ANSWER_NR, question.getAnswerNr());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getExplain());
        db.insert(RandomQuestionsTable.RANDOMTABLE_NAME, null, cv);
    }

    public List<Question> randomgetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + RandomQuestionsTable.RANDOMTABLE_NAME, null );


        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(RandomQuestionsTable.RANDOMCOLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(RandomQuestionsTable.RANDOMCOLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(RandomQuestionsTable.RANDOMCOLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(RandomQuestionsTable.RANDOMCOLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(RandomQuestionsTable.RANDOMCOLUMN_ANSWER_NR)));
//                question.setExplain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    //PARKING
    private void parkingfillQuestionsTable() {
        Question q1 = new Question("What should you do before leaving the parking space?", "A. Just go" ,

                "B. Sound your horn", "C. Look around first", 3);
        parkingaddQuestion(q1);
        Question q2 = new Question("When parking uphill and parallel to a sidewalk or curb, you should turn the wheel:", "A. parallel with the sidewalk curb" ,
                "B. away from the sidewalk curb", "C. to the sidewalk curb", 2);
        parkingaddQuestion(q2);
        Question q3 = new Question("The vehicle is parked if:",
                "A. the vehicle is stationary and remains inactive in a place for an appreciable period of time", "B. The vehicle is not moving while loading passengers in", "C. The vehicle is not moving while unloading passengers", 1);
        parkingaddQuestion(q3);
        Question q4 = new Question("In which place can't you park your vehicle? ", "A. In a given parking space", "B. In a place where pedestrians cross", "C. In a place where you want to go to", 2);
        parkingaddQuestion(q4);

        Question q5 = new Question("What light shall be used when vehicles are parked on the highway at night?", "A. Headlight", "B. Parking lights or lower-beam headlights", "C. Signal lights", 2);
        parkingaddQuestion(q5);

        Question q6 = new Question("Parking lights may be used:",
                "A. at anytime", "B. for parking and when visibility is poor", "C. when driving on a well-lighted streets", 2);
        parkingaddQuestion(q6);

        Question q7 = new Question("When parking downhill, you should turn your front wheels:", "A. toward the curb of the sidewalk", "B. away from the curb", "C. any direction will do", 1);
        parkingaddQuestion(q7);

        Question q8 = new Question("What should you do when parking uphill and there is a curb?", "A. Turn wheels to curb", "B. Turn front wheels away from the curb", "C. Make your front wheels parallel curb", 2);
        parkingaddQuestion(q8);

        Question q9 = new Question("Before moving your car from a parked position, you should:", "A. check other traffic, signal and pull from curb when it is safe to do so ", "B. signal and pull from curb", "C. sound your horn and pull from curb slowly ", 1);
        parkingaddQuestion(q9);

        Question q10 = new Question("A driver may load and unload passengers:", "A. before an intersection ", "B. whenever a passenger signals for a stop", "C. only at designated stops", 3);
        parkingaddQuestion(q10);


    }
    private void parkingaddQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(ParkingQuestionsTable.PARKINGCOLUMN_QUESTION, question.getQuestion());
        cv.put(ParkingQuestionsTable.PARKINGCOLUMN_OPTION1, question.getOption1());
        cv.put(ParkingQuestionsTable.PARKINGCOLUMN_OPTION2, question.getOption2());
        cv.put(ParkingQuestionsTable.PARKINGCOLUMN_OPTION3, question.getOption3());
        cv.put(ParkingQuestionsTable.PARKINGCOLUMN_ANSWER_NR, question.getAnswerNr());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getExplain());
        db.insert(ParkingQuestionsTable.PARKINGTABLE_NAME, null, cv);
    }

    public List<Question> parkinggetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + ParkingQuestionsTable.PARKINGTABLE_NAME, null );


        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(ParkingQuestionsTable.PARKINGCOLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(ParkingQuestionsTable.PARKINGCOLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(ParkingQuestionsTable.PARKINGCOLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(ParkingQuestionsTable.PARKINGCOLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(ParkingQuestionsTable.PARKINGCOLUMN_ANSWER_NR)));
//                question.setExplain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    //ROAD
    private void roadfillQuestionsTable() {
        Question q1 = new Question("You can overtake on the right side of the vehicle if:", "A. the highway has two or more lanes going in one direction" ,
                "B. the sidewalk is wide", "C. the road is two-way", 1);
        roadaddQuestion(q1);
        Question q2 = new Question("What should you do before turning left or right?", "A. Abruptly turn left and sound your horn" ,
                "B. Don't bother giving a signal", "C. Give a signal while no less than 30 meters before turning", 3);
        roadaddQuestion(q2);
        Question q3 = new Question("In a roundabout (rotunda), which has road rights?",
                "A. The vehicles facing the yellow light", "B. The vehicles already in the roundabout", "C. The vehicles approaching the roundabout", 2);
        roadaddQuestion(q3);
        Question q4 = new Question("You should not overtake at the foot of a sloped bridge because: ",
                "A. You can't see approaching vehicles", "B. The road is narrow", "C. Someone's crossing", 1);
        roadaddQuestion(q4);

        Question q5 = new Question("When should a driver make a decision? ",
                "A. While driving to anticipate other drivers' actions", "B. If there is heavy traffic", "C. If he is a good driver", 1);
        roadaddQuestion(q5);

        Question q6 = new Question("You should give a signal before turning right or left in an incoming intersection at a distance of:",
                "A. 30 m", "B. 60 m", "C. 15 m", 1);
        roadaddQuestion(q6);

        Question q7 = new Question("The vehicle horn is used for:",
                "A. giving warning to keep safe", "B. producing noise", "C. making beautiful sounds", 1);
        roadaddQuestion(q7);

        Question q8 = new Question("While driving, you should look at the side and rear view mirror:",
                "A. at least one second each", "B. not less than once per minute", "C. as quick as possible", 3);
        roadaddQuestion(q8);

        Question q9 = new Question("You are not allowed to overtake at the foot of a bridge because:",
                "A. the bridge is narrow", "B. it's dangerous and you cannot see oncoming vehicles", "C. people are crossing", 2);
        roadaddQuestion(q9);

        Question q10 = new Question("The proper hand signal for right turn is:",
                "A. left arm bent at elbow, hand pointing up ", "B. left arm held straight in horizontal position", "C. left arm held down and hand pointing at ground", 1);
        roadaddQuestion(q10);


    }
    private void roadaddQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(RoadQuestionsTable.ROADCOLUMN_QUESTION, question.getQuestion());
        cv.put(RoadQuestionsTable.ROADCOLUMN_OPTION1, question.getOption1());
        cv.put(RoadQuestionsTable.ROADCOLUMN_OPTION2, question.getOption2());
        cv.put(RoadQuestionsTable.ROADCOLUMN_OPTION3, question.getOption3());
        cv.put(RoadQuestionsTable.ROADCOLUMN_ANSWER_NR, question.getAnswerNr());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getExplain());
        db.insert(RoadQuestionsTable.ROADTABLE_NAME, null, cv);
    }

    public List<Question> roadgetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + RoadQuestionsTable.ROADTABLE_NAME, null );


        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(RoadQuestionsTable.ROADCOLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(RoadQuestionsTable.ROADCOLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(RoadQuestionsTable.ROADCOLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(RoadQuestionsTable.ROADCOLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(RoadQuestionsTable.ROADCOLUMN_ANSWER_NR)));
//                question.setExplain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }


    //HANDLING
    private void handlingfillQuestionsTable() {
        Question q1 = new Question("What technique can be done with a manual car when trying to get started while driving on a steep uphill gradient to prevent your car from rolling backwards?",
                "A. gas pedal technique" ,
                "B. jumpstart technique", "C. handbrake technique", 3);
        handlingaddQuestion(q1);
        Question q2 = new Question("Is shifting to neutral or coasting a good driving habit to save fuel when driving downhill?",
                "A. Yes" ,
                "B. No", "C. It Depends", 2);
        handlingaddQuestion(q2);
        Question q3 = new Question("A supplementary restraining system (SRS) designed to be used in conjunction with seatbelts. ",
                "A. Airbag", "B. Steering Wheel", "C. Brake", 1);
        handlingaddQuestion(q3);
        Question q4 = new Question("Control braking force to prevent the tyres from skidding under heavy braking or when braking in slippery conditions.  ",
                "A. Emergency brake assist ", "B. Traction control systems", "C. Antilock braking system ", 3);
        handlingaddQuestion(q4);

        Question q5 = new Question("Type of seatbelt that is placed below your hips to fully secure your",
                "A. Low", "B. Flat", "C. Firm", 1);
        handlingaddQuestion(q5);

        Question q6 = new Question("Type of seatbelt that is about every 15 minutes when you drive pull the belt firm to remove any slack.",
                "A. Low", "B. Flat", "C. Firm", 3);
        handlingaddQuestion(q6);

        Question q7 = new Question("Type of seatbelt that is no twists, turns or folds.",
                "A. Low", "B. Flat", "C. Firm", 2);
        handlingaddQuestion(q7);

        Question q8 = new Question("Detects if a vehicle is not responding correctly to driver steering input. ",
                "A. Emergency brake assist ", "B. Traction control systems", "C. Electronic Stability Control ", 3);
        handlingaddQuestion(q8);

        Question q9 = new Question("Stop the driving wheels spinning by reducing engine power or temporarily applying the brakes.  ",
                "A. Emergency brake assist ", "B. Traction control systems", "C. Electronic Stability Control ", 2);
        handlingaddQuestion(q9);

        Question q10 = new Question("Detects an emergency brake application.",
                "A. Emergency brake assist ", "B. Traction control systems", "C. Electronic Stability Control ", 1);
        handlingaddQuestion(q10);


    }
    private void handlingaddQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(HandlingQuestionsTable.HANDLINGCOLUMN_QUESTION, question.getQuestion());
        cv.put(HandlingQuestionsTable.HANDLINGCOLUMN_OPTION1, question.getOption1());
        cv.put(HandlingQuestionsTable.HANDLINGCOLUMN_OPTION2, question.getOption2());
        cv.put(HandlingQuestionsTable.HANDLINGCOLUMN_OPTION3, question.getOption3());
        cv.put(HandlingQuestionsTable.HANDLINGCOLUMN_ANSWER_NR, question.getAnswerNr());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getExplain());
        db.insert(HandlingQuestionsTable.HANDLINGTABLE_NAME, null, cv);
    }

    public List<Question> handlinggetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + HandlingQuestionsTable.HANDLINGTABLE_NAME, null );


        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(HandlingQuestionsTable.HANDLINGCOLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(HandlingQuestionsTable.HANDLINGCOLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(HandlingQuestionsTable.HANDLINGCOLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(HandlingQuestionsTable.HANDLINGCOLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(HandlingQuestionsTable.HANDLINGCOLUMN_ANSWER_NR)));
//                question.setExplain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    //VIOLATIONS
    private void violationsfillQuestionsTable() {
        Question q1 = new Question("Driving with a fake license is prohibited and is punishable by::", "A. Not more than 6 months of imprisonment" ,

                "B. Php 100.00 fine", "C. Php 1,500.00 fine with 6-month suspension of driver's license", 3);
        violationsaddQuestion(q1);
        Question q2 = new Question("The hostile and arrogant attitude of a driver towards a person in the authority or passenger in a public utility vehicle is punishable by:",
                "A. a fine of Php 500 and suspension of driver's license", "B. imprisonment of six months", "C. suspension of license for one month", 1);
        violationsaddQuestion(q2);
        Question q3 = new Question("A driver caught driving with an expired license is penalized by:",
                "A. a fine of Php 500 and suspension for one month", "B. a fine of Php 100", "C. a fine of Php 400", 3);
        violationsaddQuestion(q3);
        Question q4 = new Question("A driver caught driving an unregistered motor vehicle will be penalized by:",
                "A. fine of Php 500", "B. suspension of his driver's license for one month", "C. a fine of P2000 and confiscation of license plate or motor vehicle shall be impounded", 3);
        violationsaddQuestion(q4);

        Question q5 = new Question("Driving with a tampered taximeter is punishable by: ",
                "A. a fine of P3,000 and suspension of DL", "B. suspension of the operation of the motor vehicle", "C. evocation of the driver's license", 1);
        violationsaddQuestion(q5);

        Question q6 = new Question("What traffic violation have you committed if you pick-up passengers on prohibited zones?",
                "A. Discourtesy to motorist", "B. Reckless driving", "C. Obstructing the free flow of traffic", 3);
        violationsaddQuestion(q6);

        Question q7 = new Question("Operating a public utility vehicle equipped with stereo-music is punishable by:",
                "A. a fine of Php 1,000", "B. revocation of the license and registration certificate", "C. imprisonment of the driver and operator for six months", 1);
        violationsaddQuestion(q7);

        Question q8 = new Question("How many days are given for you to settle the case to get your license back if you get caught?",
                "A. 15 days", "B. 30 days", "C. 10 days", 1);
        violationsaddQuestion(q8);

        Question q9 = new Question("Driving without license is against the law and is punishable by:",
                "A. Php 1000", "B. Php 1500", "C. Php 500 and the vehicle will be impounded up to 10 days", 2);
        violationsaddQuestion(q9);

        Question q10 = new Question("The license of a driver who has been convicted for at least three times within a 12 month period may be revoked or suspended by the Director for:",
                "A. period not exceeding two years ", "B. three years", "C. lifetime", 1);
        violationsaddQuestion(q10);


    }
    private void violationsaddQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(ViolationsQuestionsTable.VIOLATIONSCOLUMN_QUESTION, question.getQuestion());
        cv.put(ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION1, question.getOption1());
        cv.put(ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION2, question.getOption2());
        cv.put(ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION3, question.getOption3());
        cv.put(ViolationsQuestionsTable.VIOLATIONSCOLUMN_ANSWER_NR, question.getAnswerNr());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getExplain());
        db.insert(ViolationsQuestionsTable.VIOLATIONSTABLE_NAME, null, cv);
    }

    public List<Question> violationsgetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + ViolationsQuestionsTable.VIOLATIONSTABLE_NAME, null );


        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(ViolationsQuestionsTable.VIOLATIONSCOLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(ViolationsQuestionsTable.VIOLATIONSCOLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(ViolationsQuestionsTable.VIOLATIONSCOLUMN_ANSWER_NR)));
//                question.setExplain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

//SIGNS
    private void signsfillQuestionsTable() {
        Question q1 = new Question("A continuous yellow line on the road means:",
                "A. no overtaking on the right side" ,
                "B. no overtaking on the left side", "C. overtaking on the left or right side is allowed", 2);
        signsaddQuestion(q1);
        Question q2 = new Question("You are not allowed to cross a lane with continuous yellow line on the road except if you are:",
                "A. changing lanes" ,
                "B. turning right", "C. turning left", 3);
        signsaddQuestion(q2);
        Question q3 = new Question("What is the meaning of a red traffic light?",
                "A. Go faster", "B. Stop at the given line", "C. Stop for a while and go if there is no danger ahead", 2);
        signsaddQuestion(q3);
        Question q4 = new Question("What is the meaning of a blinking red traffic light? ",
                "A. Go faster", "B. Stop at the given line", "C. Stop for a while and go if there is no danger ahead", 3);
        signsaddQuestion(q4);

        Question q5 = new Question("The three colors of traffic lights are: ", "A. red, green, and yellow",
                "B. red, green, and blue", "C. yellow, green, and blue", 1);
        signsaddQuestion(q5);

        Question q6 = new Question("Steady green light means:",
                "A. you must yield to all pedestrians and other motorists using the intersection", "B. go, it is safe to do so", "C. proceed cautiously through the intersection before the light changes to red", 2);
        signsaddQuestion(q6);

        Question q7 = new Question("The road sign \"No Entry\" is a:",
                "A. regulatory sign", "B. guide sign", "C. warning sign", 1);
        signsaddQuestion(q7);

        Question q8 = new Question("You may not cross a single broken white or yellow line:",
                "A. when turning left into a driveway", "B. when passing to the right on a one-way street", "C. when to do so would interfere with traffic", 3);
        signsaddQuestion(q8);

        Question q9 = new Question("You are in a no-passing zone when the center of the road is marked by:",
                "A. a broken yellow line ", "B. a broken white line", "C. two solid yellow lines", 3);
        signsaddQuestion(q9);

        Question q10 = new Question("What is the meaning of the yellow arrow traffic sign?",
                "A. Giving right or left direction ", "B. Vehicles are allowed to go right, left or straight", "C. The red arrow sign is about to light up", 3);
        signsaddQuestion(q10);


    }

    private void signsaddQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(SignsQuestionsTable.SIGNSCOLUMN_QUESTION, question.getQuestion());
        cv.put(SignsQuestionsTable.SIGNSCOLUMN_OPTION1, question.getOption1());
        cv.put(SignsQuestionsTable.SIGNSCOLUMN_OPTION2, question.getOption2());
        cv.put(SignsQuestionsTable.SIGNSCOLUMN_OPTION3, question.getOption3());
        cv.put(SignsQuestionsTable.SIGNSCOLUMN_ANSWER_NR, question.getAnswerNr());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getExplain());
        db.insert(SignsQuestionsTable.SIGNSTABLE_NAME, null, cv);
    }

    public List<Question> signsgetAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + SignsQuestionsTable.SIGNSTABLE_NAME, null );


        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(SignsQuestionsTable.SIGNSCOLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(SignsQuestionsTable.SIGNSCOLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(SignsQuestionsTable.SIGNSCOLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(SignsQuestionsTable.SIGNSCOLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(SignsQuestionsTable.SIGNSCOLUMN_ANSWER_NR)));
//                question.setExplain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
//GENKNOW
    private void fillQuestionsTable() {
        Question q1 = new Question("Public utility motor vehicle plates are colored:", "A. yellow with black numerals" ,

                "B. white with green numerals", "C. white with red numerals", 1);
        addQuestion(q1);
        Question q2 = new Question("A motor vehicle means any vehicle that:", "A. is propelled by any motor engine" ,
                "B. runs only on mile or traffics", "C. is propelled by muscular power such as bicycle and carts", 1);
        addQuestion(q2);
        Question q3 = new Question("To avoid suspension, how many days must a driver with an apprehended license settle his case with LTO?", "A. within 15 days", "B. within 10 days", "C. within 30 days", 1);
        addQuestion(q3);
        Question q4 = new Question("Under the basic speed law, you may never drive faster than: ", "A. that which is safe", "B. the posted speed limit", "C. the flow of traffic", 1);
        addQuestion(q4);

        Question q5 = new Question("Non-professional license is only for: ", "A. all vehicles", "B. public vehicles", "C. private vehicles", 3);
        addQuestion(q5);

        Question q6 = new Question("A driver is considered a professional if:", "A. he is a driving expert", "B. he can drive any vehicle", "C. he is paid or earns money while driving a private or public vehicle", 3);
        addQuestion(q6);

        Question q7 = new Question("Which of the following is the maximum speed limit on expressway for cars?", "A. 60 kph", "B. 80 kph", "C. 100 kph", 3);
        addQuestion(q7);

        Question q8 = new Question("When may you lend your driver's license?", "A. Under no circumstance", "B. When another person needs to learn how to drive", "C. During emergencies", 1);
        addQuestion(q8);

        Question q9 = new Question("Ignoring traffic lights during late night could:",
                "A. make you a good driver ", "B. involve you in a fatal accident", "C. decrease your fuel consumption ", 2);
        addQuestion(q9);

        Question q10 = new Question("A good driving attitude of a driver is to:",
                "A. drive slowly ", "B. drive defensively", "C. take chances if possible", 2);
        addQuestion(q10);


    }


    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
//        cv.put(QuestionsTable.COLUMN_EXPLAIN, question.getExplain());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null );


        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
//                question.setExplain(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_EXPLAIN)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }





}
