package com.example.android.learningportal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Krishna on 10/2/2016.
 */

public class LoginDatabaseAdapter {

    static final int DATABASE_VERSION = 114;
    static final String DATABASE_NAME ="contact.db";
    static final String TABLE_NAME = "loginTb";
    static final String COLUMN_ID = "_id";
    private  static  final String COLUMN_FNAME="fname";
    private  static  final String COLUMN_LNAME="lname";
    private  static  final String COLUMN_EMAIL="email";
    private  static  final String COLUMN_DOB="dob";
    private  static  final String COLUMN_PWD="pwd";
    private  static  final String COLUMN_CPWD="cpwd";

    private  static  final String COLUMN_PHNO="phno";
    static final String TABLE_CREATE_QUERY = "create table "+TABLE_NAME+" (" +COLUMN_ID+ " INTEGER PRIMARY KEY, "
            +COLUMN_FNAME+ " TEXT NOT NULL," +COLUMN_LNAME+ " TEXT NOT NULL," +COLUMN_EMAIL+ " TEXT NOT NULL,"
            +COLUMN_DOB+ " TEXT NOT NULL," +COLUMN_PWD+ " TEXT NOT NULL," +COLUMN_CPWD+ " TEXT NOT NULL,"
            +COLUMN_PHNO+ " TEXT NOT NULL)";

    public SQLiteDatabase db;
    private final Context context;

    private DatabaseHelper dbHelper;
    public  LoginDatabaseAdapter(Context _context)
    {
        this.context = _context;
        dbHelper = new DatabaseHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public LoginDatabaseAdapter open() throws  SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(Compact c)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_FNAME,c.getFname());
        contentValues.put(COLUMN_LNAME,c.getlname());
        contentValues.put(COLUMN_EMAIL,c.getemail());
        contentValues.put(COLUMN_DOB,c.getdob());
        contentValues.put(COLUMN_PWD,c.getpwd());
        contentValues.put(COLUMN_CPWD,c.getcpwd());
        contentValues.put(COLUMN_PHNO,c.getphno());

        db.insert(TABLE_NAME, null, contentValues);
    }

    public String getSingleEntry(String userName)
    {
        Cursor cursor=db.query(TABLE_NAME, null, " email=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex(COLUMN_PWD));
        cursor.close();
        return password;
    }


}
