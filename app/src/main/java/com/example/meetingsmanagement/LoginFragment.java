package com.example.meetingsmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    TextView usernameTxt,passwordTxt;
    Button loginBtn;
    MeetingData DB;

    float alfa = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment,container,false);

        usernameTxt = root.findViewById(R.id.username);
        passwordTxt = root.findViewById(R.id.password);
        loginBtn = root.findViewById(R.id.login_btn);
        DB = new MeetingData(getActivity());
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginID = usernameTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                if(TextUtils.isEmpty(loginID)||TextUtils.isEmpty(password))
                {
                    Toast.makeText(getActivity(),"All Fields are required",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean validation = DB.checkUserIDPassword(loginID,password);
                    if(validation)
                    {
                        Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity().getApplicationContext(),MeetingActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("loginID",loginID);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getActivity(),"Login Failed",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

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
