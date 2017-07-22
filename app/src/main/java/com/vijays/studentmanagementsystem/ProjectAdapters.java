package com.vijays.studentmanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aditya on 22/7/17.
 */

public class ProjectAdapters extends RecyclerView.Adapter<ProjectAdapters.ViewHolder> {
    List<Project> pro;
    private Context context;
    public ProjectAdapters(List<Project> a,Context context){
    super();
        this.pro=a;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context)
                .inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView StuName;
        public ViewHolder(View itemView) {
            super(itemView);
            StuName=(TextView)itemView.findViewById(R.id.student);

        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Project p=pro.get(position);
        holder.StuName.setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return pro.size();
    }
}
