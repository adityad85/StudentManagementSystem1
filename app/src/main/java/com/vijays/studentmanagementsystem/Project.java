package com.vijays.studentmanagementsystem;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.NavigableMap;
import java.util.jar.Attributes;

/**
 * Created by aditya on 21/7/17.
 */

public class Project implements Parcelable {
    public String Name,Year,College,ProjName,Remarks;
    public Project(){

    }

    protected Project(Parcel in) {
        Name = in.readString();
        Year = in.readString();
        College = in.readString();
        ProjName = in.readString();
        Remarks = in.readString();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    public  void setName(String a){
        this.Name=a;
    }
    public void setYear(String a){
        this.Year=a;
    }
    public void setCollege(String a){
        this.College=a;
    }
    public void setProjName(String a){
        this.ProjName=a;
    }
    public void setRemarks(String a){
        this.Remarks=a;
    }
    public String getName(){
        return Name;
    }

    public String getYear(){
        return Year;
    }

    public String getCollege(){
        return College;
    }

    public String getRemarks(){
        return Remarks;
    }

    public String getProjName(){
        return ProjName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Year);
        parcel.writeString(College);
        parcel.writeString(ProjName);
        parcel.writeString(Remarks);
    }
}
