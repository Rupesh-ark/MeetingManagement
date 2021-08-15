package com.example.meetingsmanagement;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class MeetingActivity extends AppCompatActivity implements View.OnClickListener {


    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MeetingAdapter meetingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);

        FragmentManager fm = getSupportFragmentManager();
        meetingAdapter = new MeetingAdapter(fm,getLifecycle());
        viewPager2.setAdapter(meetingAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Schedule Meeting"));
        tabLayout.addTab(tabLayout.newTab().setText("Your Meetings"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }

    @Override
    public void onClick(View v) {

    }
}
