package com.roadbooks.project;

import android.provider.BaseColumns;

public final class QuizContract {

    private QuizContract() {
    }
    //genknow
    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
//        public static final String COLUMN_EXPLAIN = "explain";
    }
    //emer
    public static class EmerQuestionsTable implements BaseColumns {
        public static final String EMERTABLE_NAME = "emerquiz_questions";
        public static final String EMERCOLUMN_QUESTION = "question";
        public static final String EMERCOLUMN_OPTION1 = "option1";
        public static final String EMERCOLUMN_OPTION2 = "option2";
        public static final String EMERCOLUMN_OPTION3 = "option3";
        public static final String EMERCOLUMN_ANSWER_NR = "answer_nr";
//        public static final String COLUMN_EXPLAIN = "explain";
    }

    //signs
    public static class SignsQuestionsTable implements BaseColumns {
        public static final String SIGNSTABLE_NAME = "signsquiz_questions";
        public static final String SIGNSCOLUMN_QUESTION = "question";
        public static final String SIGNSCOLUMN_OPTION1 = "option1";
        public static final String SIGNSCOLUMN_OPTION2 = "option2";
        public static final String SIGNSCOLUMN_OPTION3 = "option3";
        public static final String SIGNSCOLUMN_ANSWER_NR = "answer_nr";
//        public static final String COLUMN_EXPLAIN = "explain";
    }

    //violations
    public static class ViolationsQuestionsTable implements BaseColumns {
        public static final String VIOLATIONSTABLE_NAME = "violationsquiz_questions";
        public static final String VIOLATIONSCOLUMN_QUESTION = "question";
        public static final String VIOLATIONSCOLUMN_OPTION1 = "option1";
        public static final String VIOLATIONSCOLUMN_OPTION2 = "option2";
        public static final String VIOLATIONSCOLUMN_OPTION3 = "option3";
        public static final String VIOLATIONSCOLUMN_ANSWER_NR = "answer_nr";
//        public static final String COLUMN_EXPLAIN = "explain";
    }
    //handling
    public static class HandlingQuestionsTable implements BaseColumns {
        public static final String HANDLINGTABLE_NAME = "handlingquiz_questions";
        public static final String HANDLINGCOLUMN_QUESTION = "question";
        public static final String HANDLINGCOLUMN_OPTION1 = "option1";
        public static final String HANDLINGCOLUMN_OPTION2 = "option2";
        public static final String HANDLINGCOLUMN_OPTION3 = "option3";
        public static final String HANDLINGCOLUMN_ANSWER_NR = "answer_nr";
//        public static final String COLUMN_EXPLAIN = "explain";
    }

    //road
    public static class RoadQuestionsTable implements BaseColumns {
        public static final String ROADTABLE_NAME = "roadquiz_questions";
        public static final String ROADCOLUMN_QUESTION = "question";
        public static final String ROADCOLUMN_OPTION1 = "option1";
        public static final String ROADCOLUMN_OPTION2 = "option2";
        public static final String ROADCOLUMN_OPTION3 = "option3";
        public static final String ROADCOLUMN_ANSWER_NR = "answer_nr";
//        public static final String COLUMN_EXPLAIN = "explain";
    }

    //parking
    public static class ParkingQuestionsTable implements BaseColumns {
        public static final String PARKINGTABLE_NAME = "parkingquiz_questions";
        public static final String PARKINGCOLUMN_QUESTION = "question";
        public static final String PARKINGCOLUMN_OPTION1 = "option1";
        public static final String PARKINGCOLUMN_OPTION2 = "option2";
        public static final String PARKINGCOLUMN_OPTION3 = "option3";
        public static final String PARKINGCOLUMN_ANSWER_NR = "answer_nr";
//        public static final String COLUMN_EXPLAIN = "explain";
    }

    //random
    public static class RandomQuestionsTable implements BaseColumns {
        public static final String RANDOMTABLE_NAME = "randomquiz_questions";
        public static final String RANDOMCOLUMN_QUESTION = "question";
        public static final String RANDOMCOLUMN_OPTION1 = "option1";
        public static final String RANDOMCOLUMN_OPTION2 = "option2";
        public static final String RANDOMCOLUMN_OPTION3 = "option3";
        public static final String RANDOMCOLUMN_ANSWER_NR = "answer_nr";
//        public static final String COLUMN_EXPLAIN = "explain";
    }
}
