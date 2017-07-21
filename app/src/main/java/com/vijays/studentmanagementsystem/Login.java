package com.vijays.studentmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void jumpToHomeScreen(View v){
        Intent i = new Intent(getApplicationContext(), Home.class);
        startActivity(i)

        ;
    }
    //@Override
    //protected void attachBaseContext(Context newBase) {
      //  super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    //}
}
