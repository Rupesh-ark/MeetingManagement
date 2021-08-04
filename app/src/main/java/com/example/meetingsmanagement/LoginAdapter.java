package com.example.meetingsmanagement;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;



public class LoginAdapter extends FragmentStateAdapter {



    public LoginAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
            LoginFragment loginFragment = new LoginFragment();
            return loginFragment;

            case 1:
                SignupFragment signupFragment = new SignupFragment();
                return signupFragment;
            default:
                return null;

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
