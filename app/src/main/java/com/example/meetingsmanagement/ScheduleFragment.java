package com.example.meetingsmanagement;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.Locale;

public class ScheduleFragment extends Fragment {


    private Button dateButton;
    private TextView datePicked;
    private Button timeButton;
    private TextView timePicked;
    private Button insertMeeting;
    private EditText agendaText;
    int hour,minute;
    MeetingData DB;
    String loginID;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.schedule_tab_fragment,container,false);

        Bundle bundle = getActivity().getIntent().getExtras();
        loginID = bundle.getString("loginID");


        dateButton = root.findViewById(R.id.date_button);
        datePicked = root.findViewById(R.id.selected_date);
        timeButton = root.findViewById(R.id.time_button);
        timePicked = root.findViewById(R.id.time_picked);
        agendaText = root.findViewById(R.id.agenda);
        insertMeeting = root.findViewById(R.id.insert_meeting);
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

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour = selectedHour;
                        minute = selectedMinute;
                        timePicked.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),onTimeSetListener,hour,minute,true);
                timePickerDialog.setTitle("Select Meeting Time");
                timePickerDialog.show();
            }
        });

        insertMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String date = datePicked.getText().toString();
                String time = timePicked.getText().toString();
                String agenda = agendaText.getText().toString();

                if(TextUtils.isEmpty(date)||TextUtils.isEmpty(time)||TextUtils.isEmpty(agenda))
                {
                    Toast.makeText(getActivity(),"All Fields are required",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean isMeetingDuplicate = DB.checkMeetingDuplicate(loginID,date,time);
                    if(!isMeetingDuplicate)
                    {
                        Boolean insert = DB.insertMeetingsData(loginID,date,time,agenda);
                        if(insert)
                        {
                            Toast.makeText(getActivity(), "Meeting Registered Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getActivity(), "Meeting Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Meeting Already Exists", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        return root;
    }


}
