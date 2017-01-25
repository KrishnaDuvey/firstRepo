package com.example.android.learningportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Question5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
    }



    public void Question(View v) {
        if (v.getId() == R.id.q5) {
            Intent intent = new Intent(this, Result.class);
            //Question1 q1= new Question1(String name);
            startActivity(intent);


        }


    }

}
