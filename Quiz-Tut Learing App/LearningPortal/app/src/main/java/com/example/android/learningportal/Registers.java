
package com.example.android.learningportal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.learningportal.Main2Activity;
import com.example.android.learningportal.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.os.Build.VERSION_CODES.M;

public class Registers extends AppCompatActivity {

    LoginDatabaseAdapter loginDatabaseAdapter;
//DatabaseHelper helper=new DatabaseHelper(this);

    EditText fnameEdit, lnameEdit, emailEdit, dobEdit, passEdit, confirmEdit, phEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registers);
       loginDatabaseAdapter=new LoginDatabaseAdapter(this);
        loginDatabaseAdapter=loginDatabaseAdapter.open();


    }

    public void onSignupClicked(View v)
    {
        if(v.getId() == R.id.signupButton)
        {

            fnameEdit = (EditText) findViewById(R.id.fname_editText);
            lnameEdit = (EditText) findViewById(R.id.lname_editText);
            emailEdit = (EditText) findViewById(R.id.email_editText);
            dobEdit = (EditText) findViewById(R.id.dob_editText);
            passEdit = (EditText) findViewById(R.id.pass_editText);
            confirmEdit = (EditText) findViewById(R.id.confirm_pass_editText);
            phEdit = (EditText) findViewById(R.id.phno_editText);

            String fname = fnameEdit.getText().toString();
            String lname = lnameEdit.getText().toString();
            String email = emailEdit.getText().toString();
            String dob = dobEdit.getText().toString();
            String pass = passEdit.getText().toString();
            String confirmPass = confirmEdit.getText().toString();
            String phone = phEdit.getText().toString();

            if(fname.equals("")||lname.equals("")||email.equals("")||dob.equals("")||pass.equals("")||confirmPass.equals("")||phone.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                return;
            }
            // check if both password matches
            if(!pass.equals(confirmPass))
            {
                Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                Compact compact = new Compact();
                compact.setfname(fname);
                compact.setlname(lname);
                compact.setemail(email);
                compact.setdob(dob);
                compact.setpwd(pass);
                compact.setcpwd(confirmPass);
                compact.setphno(phone);

                loginDatabaseAdapter.insertEntry(compact);
                Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
            }

        }
    }

}
