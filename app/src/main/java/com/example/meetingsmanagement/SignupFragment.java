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

public class SignupFragment extends Fragment {

    TextView usernameTxt,passwordTxt,confirmPasswordTxt,companyTxt;
    Button signupBtn;
    MeetingData DB;
    float alfa = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);
        usernameTxt = root.findViewById(R.id.username);
        passwordTxt = root.findViewById(R.id.password);
        confirmPasswordTxt = root.findViewById(R.id.confirm_password);
        companyTxt = root.findViewById(R.id.company);
        signupBtn = root.findViewById(R.id.signup_btn);
        DB = new MeetingData(getActivity());

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginID= usernameTxt.getText().toString();
                String password = passwordTxt.getText().toString();
                String confirmPass = confirmPasswordTxt.getText().toString();
                String companyName = companyTxt.getText().toString();

                if(TextUtils.isEmpty(loginID)||TextUtils.isEmpty(password)||TextUtils.isEmpty(confirmPass)||TextUtils.isEmpty(companyName))
                {
                    Toast.makeText(getActivity(),"All Fields are required",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(password.equals(confirmPass))
                    {
                        Boolean checkDuplicate = DB.checkUserIDDuplicate(loginID);
                        if(checkDuplicate==false)
                        {
                            Boolean insert = DB.insertUsersData(loginID,password,companyName);
                            if(insert == true) {

                                Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                   Intent intent = new Intent(getActivity().getApplicationContext(),MeetingActivity.class);
                                   Bundle bundle = new Bundle();
                                   bundle.putString("loginID",loginID);
                                   intent.putExtras(bundle);
                                   startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(getActivity(), "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getActivity(), "User Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getActivity(), "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

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