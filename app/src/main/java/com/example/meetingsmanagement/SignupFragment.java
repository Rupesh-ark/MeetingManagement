package com.example.meetingsmanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SignupFragment extends Fragment {

    TextView usernameTxt,passwordTxt,confirmPasswordTxt,companyTxt;
    Button signupBtn;
    float alfa = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
        usernameTxt = root.findViewById(R.id.username);
        passwordTxt = root.findViewById(R.id.password);
        confirmPasswordTxt = root.findViewById(R.id.confirm_password);
        companyTxt = root.findViewById(R.id.company);
        signupBtn = root.findViewById(R.id.signup_btn);

        usernameTxt.setTranslationX(800);
        passwordTxt.setTranslationX(800);
        confirmPasswordTxt.setTranslationX(800);
        companyTxt.setTranslationX(800);
        signupBtn.setTranslationX(800);

        usernameTxt.setAlpha(alfa);
        passwordTxt.setAlpha(alfa);
        confirmPasswordTxt.setAlpha(alfa);
        companyTxt.setAlpha(alfa);
        signupBtn.setAlpha(alfa);

        usernameTxt.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passwordTxt.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        confirmPasswordTxt.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        companyTxt.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        signupBtn.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();



        return root;
    }
}