package com.vijays.studentmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.Adapter adapter;
    private ArrayList<Project> projectlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView=(RecyclerView)findViewById(R.id.recy);
        setSupportActionBar(toolbar);
        recyclerView.setHasFixedSize(false);
        getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddStudent.class);
                startActivity(i);

            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,recyclerView,new ClickListener(){

            @Override
            public void onClick(View view, int position) {
                Intent im=new Intent(getApplicationContext(),StudentProfile.class);
                Project q=projectlist.get(position);
                im.putExtra("data",q);
                startActivity(im);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Intent intent = new Intent(getApplicationContext(), About.class);
            startActivity(intent);


        }
        if (id == R.id.action_logout) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


    public void getData() {
        ParseQuery<ParseObject> q=new ParseQuery<ParseObject>("Projects");
        q.addAscendingOrder("Name");
        try {
            List<ParseObject> a= q.find();
            for(ParseObject ob:a){
                Project p=new Project();
                p.setName(ob.get("Name").toString());
                p.setProjName(ob.get("ProjName").toString());
                p.setRemarks(ob.get("Remarks").toString());
                p.setYear(ob.get("Year").toString());
                p.setCollege(ob.get("College").toString());
                projectlist.add(p);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private ClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){

            this.clicklistener=clicklistener;
            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
                clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
