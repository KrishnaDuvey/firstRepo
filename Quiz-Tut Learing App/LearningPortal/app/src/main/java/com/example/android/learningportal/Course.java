package com.example.android.learningportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }


    public void Clickly(View v) {
        if (v.getId() == R.id.hadoop) {
            Intent intent = new Intent(this, CourseContent.class);
            //Question1 q1= new Question1(String name);
            startActivity(intent);


        }
        if (v.getId() == R.id.java) {
            Intent intent = new Intent(this, CourseContent.class);
            //Question1 q1= new Question1(String name);
            startActivity(intent);


        }
    }

}
