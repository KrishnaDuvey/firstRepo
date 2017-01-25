package com.example.android.learningportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InterView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_view);
    }


    public void Clicked(View v)
    {
        if(v.getId()==R.id.javaInterview)
        {
            Intent intent = new Intent(this,javaInterview.class);
            //Question1 q1= new Question1(String name);
            startActivity(intent);



        }

        if(v.getId() == R.id.hadoopInterview)
        {

            Intent i = new Intent(this, hadoopInterview.class);
            startActivity(i);
        }


    }

}
