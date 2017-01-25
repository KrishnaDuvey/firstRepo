package com.example.android.learningportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Krishna on 10/9/2016.
 */

public class Question10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);

    }

    public void Question(View v) {
        if (v.getId() == R.id.q10) {
            Intent intent = new Intent(this, Result.class);
            //Question1 q1= new Question1(String name);
            startActivity(intent);


        }
    }
}

