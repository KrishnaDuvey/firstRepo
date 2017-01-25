package com.example.android.learningportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Question3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
    }



    public void Question(View v) {
        if (v.getId() == R.id.q1) {
            Intent intent = new Intent(this, Question4.class);
            //Question1 q1= new Question1(String name);
            startActivity(intent);


        }
    }
}
