package com.example.meetingsmanagement;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MeetingAdapter extends FragmentStateAdapter {

    public MeetingAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                ScheduleFragment scheduleFragment = new ScheduleFragment();
                return scheduleFragment;

            case 1:
                InformationFragment informationFragment = new InformationFragment();
                return informationFragment;
            default:
                return null;

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
