package com.example.android.learningportal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.bluetooth.BluetoothAssignedNumbers.IBM;
import static com.example.android.learningportal.LoginDatabaseAdapter.TABLE_NAME;
import static com.example.android.learningportal.R.id.courses;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 244;
    // Database Name
    private static final String DATABASE_NAME = "quizTut.db";
    // tasks table name
    private static final String TABLE_QUEST = "quizTu";
    // tasks Table Columns names
    private static final String KEY_ID = "id1";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd";
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT,"+KEY_OPTD+" TEXT, " + KEY_ANSWER+ " TEXT)";
        db.execSQL(sql);
        addQuestions();
//db.close();
    }
    private void addQuestions()
    {
        Question q1=new Question("IBM and ________ have announced a major initiative to use Hadoop to support university courses in distributed computer programming.","Google Latitude","Android(operating system)","Google Variations", "Google","Google Variations");
        this.addQuestion(q1);
        Question q2=new Question("Point out the correct statement : an operating system?", "Hadoop is an ideal environment for extracting and transforming small volumes of data",
                "Hadoop stores data in HDFS and supports data compression/decompression",
                " The Giraph framework is less useful than a MapReduce job to solve graph and machine learning",
                "None of the mentioned","Hadoop stores data in HDFS and supports data compression/decompression");
        this.addQuestion(q2);
        Question q3=new Question("What license is Hadoop distributed under ?","Apache License 2.0", "Mozilla Public License","Shareware","Commercial","Apache License 2.0");
        this.addQuestion(q3);
        Question q4=new Question("Sun also has the Hadoop Live CD ________ project, which allows running a fully functional Hadoop cluster using a live CD.",
                "OpenOffice.org", "OpenSolaris", "GNU","Linux","OpenSolaris");
        this.addQuestion(q4);
        Question q5=new Question("Which of the following genres does Hadoop produce ?","Distributed file system","JAX-RS","Java Message Service","Relational Database Management System","Distributed file system");
        this.addQuestion(q5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
  //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(KEY_ID,quest.getID());
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        values.put(KEY_ANSWER, quest.getANSWER());

// Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setOPTA(cursor.getString(2));
                quest.setOPTB(cursor.getString(3));
                quest.setOPTC(cursor.getString(4));
                quest.setOPTD(cursor.getString(5));
                quest.setANSWER(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}