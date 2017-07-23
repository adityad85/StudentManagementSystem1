package com.vijays.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class StudentProfile extends AppCompatActivity {
    Project qw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i=getIntent();
        qw=i.getExtras().getParcelable("data");
        TextView name,yar,college,projn,remarks;
        name= (TextView) findViewById(R.id.studentOne);
        yar=(TextView)findViewById(R.id.year);
        college=(TextView)findViewById(R.id.college);
        projn=(TextView)findViewById(R.id.projn);
        remarks=(TextView)findViewById(R.id.remarks);
        name.setText(qw.getName());
        yar.setText(qw.getYear());
        college.setText(qw.getCollege());
        projn.setText(qw.getProjName());
        remarks.setText(qw.getRemarks());
    }

    public void delete(View view) {
        ParseQuery<ParseObject> query=new ParseQuery<ParseObject>("Projects");
        query.whereContains("Name",qw.getName());
        query.whereContains("College",qw.getCollege());
        query.whereContains("Year",qw.getYear());
        query.whereContains("Remarks",qw.getRemarks());
        query.whereContains("ProjName",qw.getProjName());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(objects.size()>0){
                    ParseObject ob=objects.get(0);
                    ob.deleteInBackground();
                    Intent i=new Intent(getApplication(),Home.class);
                    startActivity(i);
                    finish();
                }
                if(e!=null)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
