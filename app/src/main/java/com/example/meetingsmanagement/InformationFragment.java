package com.example.meetingsmanagement;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class InformationFragment extends Fragment {

    private Button dateButton;
    private Button displayMeetings;
    private TextView datePicked;
    MeetingData DB;
    String loginID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.information_tab_fragment,container,false);

        Bundle bundle = getActivity().getIntent().getExtras();
        loginID = bundle.getString("loginID");


        dateButton = root.findViewById(R.id.date_button);
        displayMeetings = root.findViewById(R.id.display_button);
        datePicked = root.findViewById(R.id.selected_date);
        DB = new MeetingData(getActivity());

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Select Meeting Date");
        MaterialDatePicker materialDatePicker = builder.build();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getActivity().getSupportFragmentManager(),"Meeting_Date_Picker");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                datePicked.setText(materialDatePicker.getHeaderText());
            }
        });


        displayMeetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = datePicked.getText().toString();
                if(TextUtils.isEmpty(date))
                {
                    Toast.makeText(getActivity(),"All Fields are required",Toast.LENGTH_SHORT).show();
                }
                else{
                    Cursor res = DB.getMeetingData(loginID,date);
                    if(res.getCount()==0) {
                        Toast.makeText(getActivity(), "No Meeting on this date", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()){
                        buffer.append("Meeting Time:" + res.getString(0)+"\n");
                        buffer.append("Meeting Agenda:" + res.getString(1)+"\n\n");
                    }

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                    builder1.setCancelable(true);
                    builder1.setTitle("Meetings on " + date);
                    builder1.setMessage(buffer.toString());
                    builder1.show();

                }
            }
        });

        return root;
    }


}
