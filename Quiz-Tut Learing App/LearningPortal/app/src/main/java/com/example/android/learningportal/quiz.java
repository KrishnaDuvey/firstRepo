package com.example.android.learningportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.R.attr.name;


public class quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qui);
    }


    public void Clicked(View v)
    {
        if(v.getId()==R.id.javaQuiz)
        {
                            Intent intent = new Intent(this,QuizActivity.class);
                //Question1 q1= new Question1(String name);
                startActivity(intent);



        }

        if(v.getId() == R.id.hadoopQuiz)
        {

            Intent i = new Intent(this, QuizActivity.class);
            startActivity(i);
        }


    }

}
