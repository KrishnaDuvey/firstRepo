package com.example.android.learningportal;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        TextView t1=(TextView)findViewById(R.id.textScore);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");

    //    makeText(this, ""+score, Toast.LENGTH_SHORT).show();
//display score
     //int score=4;
        bar.setRating(score);
        switch (score)
        {
            case 1:t.setText("Oopsie! Better Luck Next Time!");
            case 2:
                    t1.setText("Your Score ="+score);
                break;
            case 3:
                t.setText("Hmmmm.. Someone's been reading a lot of Quiz");
                t1.setText("Your Score ="+score+"/5");
                break;

            case 4:
                   t1.setText("Your Score ="+score+"/5");
                break;
            case 5:t.setText("Who are you? A Quiz wizard???");
                t1.setText("Your Score ="+score+"/5");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}