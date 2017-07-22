package com.vijays.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class AddStudent extends AppCompatActivity {
    EditText name,year,college,proj,remarks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name=(EditText)findViewById(R.id.ename);
        year=(EditText)findViewById(R.id.eyear);
        college=(EditText)findViewById(R.id.ecname);
        proj=(EditText)findViewById(R.id.epname);
        remarks=(EditText)findViewById(R.id.enterTextArea);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void jumpTOHomeScreen1(View v){
        ParseObject object=new ParseObject("Projects");
        object.put("Name",name.getText());
        object.put("College",college.getText());
        object.put("Year",year.getText());
        object.put("ProjName",proj.getText());
        object.put("Remarks",remarks.getText());
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Intent i = new Intent(getApplicationContext(),Home.class);
                startActivity(i);
if(e!=null){
    Toast.makeText(getApplicationContext(),"Some Error",Toast.LENGTH_LONG).show();
}
            }

        });
         }

}
