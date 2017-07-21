package com.vijays.studentmanagementsystem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aditya on 22/7/17.
 */

public class ProjectAdapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
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
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
