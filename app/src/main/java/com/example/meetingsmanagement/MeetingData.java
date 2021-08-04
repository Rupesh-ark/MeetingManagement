package com.example.meetingsmanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class MeetingData extends SQLiteOpenHelper {

    public static String DBName="meeting.db";

    public MeetingData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);



    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table User(loginID TEXT primary key, password TEXT)");
        db.execSQL("create table MeetingPortfolio(portfolioID TEXT,foreign key(portfolioID) references User(loginID))");
        db.execSQL("create table Meetings(portfolioID TEXT,meetingDate TEXT, foreign key(portfolioID) references MeetingPortfolio(portfolioID))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
