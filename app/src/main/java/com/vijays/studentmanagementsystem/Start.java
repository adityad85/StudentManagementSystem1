package com.vijays.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.parse.ParseUser;

/**
 * Created by aditya on 22/7/17.
 */

public class Start extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseUser yo=ParseUser.getCurrentUser();
        if(yo!=null){
            Intent i=new Intent(getApplication(),Home.class);
            startActivity(i);
        }else
        {
            Intent i=new Intent(getApplication(),Login.class);
            startActivity(i);

        }
    }

}
