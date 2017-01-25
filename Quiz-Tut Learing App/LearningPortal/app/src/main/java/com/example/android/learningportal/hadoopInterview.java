package com.example.android.learningportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hadoopInterview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadoop_interview);
    }

    public void pdhlo(View v) {
        if (v.getId() == R.id.c1) {
            Intent intent = new Intent(this, bigdata.class);
            startActivity(intent);


        }
        if (v.getId() == R.id.c2) {
            Intent intent = new Intent(this, hdfs.class);
            startActivity(intent);


        }
    }
}
