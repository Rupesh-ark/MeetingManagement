package com.example.meetingsmanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    TextView usernameTxt,passwordTxt;
    Button loginBtn;
    float alfa = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        usernameTxt = root.findViewById(R.id.username);
        passwordTxt = root.findViewById(R.id.password);
        loginBtn = root.findViewById(R.id.login_btn);

        usernameTxt.setTranslationX(800);
        passwordTxt.setTranslationX(800);
        loginBtn.setTranslationX(800);

        usernameTxt.setAlpha(alfa);
        passwordTxt.setAlpha(alfa);
        loginBtn.setAlpha(alfa);

        usernameTxt.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        passwordTxt.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        loginBtn.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }




}
