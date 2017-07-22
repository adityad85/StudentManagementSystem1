package com.vijays.studentmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
public class Login extends AppCompatActivity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.pass);
    }

    public void jumpToHomeScreen(View v){
        ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
                finish();
                if(e!=null){
                    Toast.makeText(getApplicationContext(),"Please Enter Correct Credentials",Toast.LENGTH_LONG).show();
                }
            }

        });

        ;
    }
    //@Override
    //protected void attachBaseContext(Context newBase) {
      //  super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

}
