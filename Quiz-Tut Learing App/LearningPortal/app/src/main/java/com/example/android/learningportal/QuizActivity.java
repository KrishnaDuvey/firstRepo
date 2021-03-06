package com.example.android.learningportal;
        import java.util.List;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.Menu;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import static android.widget.Toast.makeText;
        import static com.example.android.learningportal.R.id.c;
        import static com.example.android.learningportal.R.id.username;

public class QuizActivity extends AppCompatActivity {
    List<Question> quesList;

    DbHelper db1;
            int score=0;
String username="";
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc,rdd;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        db1=new DbHelper(this);

        quesList=db1.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton)findViewById(R.id.radio3);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();




        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());

                if(answer.getText().toString().equalsIgnoreCase(currentQ.getANSWER()))
                {
                    score++;
                    //Log.d("score", "Your score"+score);
                }


                if(qid<5){
                    currentQ=quesList.get(qid);
                    setQuestionView();

                }
                else
                {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    b.putString("username", username);
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());
        qid++;
    }
}
