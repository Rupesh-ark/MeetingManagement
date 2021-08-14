package com.example.meetingsmanagement;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class MeetingActivity extends AppCompatActivity implements View.OnClickListener {


    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MeetingAdapter meetingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onClick(View v) {

    }
}
