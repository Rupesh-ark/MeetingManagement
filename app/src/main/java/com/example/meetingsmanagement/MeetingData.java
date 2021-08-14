package com.example.meetingsmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MeetingData extends SQLiteOpenHelper {

    public static final String DBName="meeting.db";

    public MeetingData(Context context) {
        super(context, "meeting.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Users(loginID TEXT primary key, password TEXT, companyName TEXT)");
        db.execSQL("create table Meetings(meetingID TEXT,meetingDate TEXT,meetingTime TEXT,meetingAgenda TEXT,foreign key(meetingID) references Users(loginID) on delete cascade)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Users");
    }

    public Boolean insertUsersData(String loginID, String password, String companyName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("loginID",loginID);
        values.put("password",password);
        values.put("companyName",companyName);

        long result = db.insert("Users",null,values);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Boolean insertMeetingsData(String meetingID,String meetingDate,String meetingTime, String meetingAgenda)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("meetingID",meetingID);
        values.put("meetingDate",meetingDate);
        values.put("meetingTime",meetingTime);
        values.put("meetingAgenda",meetingAgenda);

        long result = db.insert("Meetings",null,values);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Boolean checkUserIDDuplicate(String loginID){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Users where loginID=?", new String[] {loginID});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkUserIDPassword(String loginID, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Users where loginID=? and password=?", new String[] {loginID,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }


}
