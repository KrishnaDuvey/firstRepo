
package com.example.android.learningportal;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.password;
import static android.widget.Toast.makeText;
import static com.example.android.learningportal.R.id.email_editText;
import static com.example.android.learningportal.R.id.loginb;
import static com.example.android.learningportal.R.id.username;


public class Main2Activity extends AppCompatActivity {

    LoginDatabaseAdapter loginDatabaseAdapter;
        EditText userEdit, passEdit;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            loginDatabaseAdapter = new LoginDatabaseAdapter(this);
            loginDatabaseAdapter = loginDatabaseAdapter.open();

        }

    public void Clicked(View v)
    {
        if(v.getId()==R.id.loginb)
        {
            userEdit = (EditText) findViewById(R.id.username);
            String str = userEdit.getText().toString();
            passEdit = (EditText) findViewById(R.id.view);
            String pass = passEdit.getText().toString();

            String storedPassword =loginDatabaseAdapter.getSingleEntry(str);
            //String password=helper.searchpass(str);
            if(pass.equals(storedPassword))
            {
                Intent intent = new Intent(this,MainActivity.class);

                Bundle b = new Bundle();

                b.putString("username", str);
                intent.putExtras(b); //Put your score to your next Intent

                makeText(Main2Activity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                startActivity(intent);

            }
            else
            {
                Toast temp =  makeText(this, "Incorrect Username or Password", Toast.LENGTH_SHORT);
                temp.show();
            }


        }

        if(v.getId() == R.id.signupButton)
        {

            Intent i = new Intent(Main2Activity.this, Registers.class);
            startActivity(i);
        }


    }


    /*
   @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDatabaseAdapter.close();
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDatabaseAdapter.close();
    }
}

