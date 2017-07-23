package com.vijays.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
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
    Boolean ans=false;
    View focusView=null;
public void check(){
    if(TextUtils.isEmpty(name.getText().toString())){
        name.setError("Please Enter");
        focusView=name;
        ans=true;
    }
    else if(TextUtils.isEmpty(year.getText().toString())){
        year.setError("Please Enter");
        focusView=year;
        ans=true;
    }else if(TextUtils.isEmpty(college.getText().toString())){
        college.setError("Please Enter");
        focusView=college;
        ans=true;
    }else if(TextUtils.isEmpty(proj.getText().toString())){
        proj.setError("Please Enter");
        focusView=proj;
        ans=true;
    }else if(TextUtils.isEmpty(remarks.getText().toString())){
        remarks.setError("Please Enter");
        focusView=remarks;
        ans=true;
    }else ans=false;


}
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void jumpTOHomeScreen1(View v){
        check();
        if(ans){
         focusView.requestFocus();
        }else {
            ParseObject object = new ParseObject("Projects");
            object.put("Name", name.getText().toString());
            object.put("College", college.getText().toString());
            object.put("Year", year.getText().toString());
            object.put("ProjName", proj.getText().toString());
            object.put("Remarks", remarks.getText().toString());
            object.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);
                    if (e != null) {
                        Toast.makeText(getApplicationContext(), "Some Error", Toast.LENGTH_LONG).show();
                    }
                }

            });
        } }

}
