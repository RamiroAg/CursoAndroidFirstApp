package com.androidapps.guti.teameventsmanager.events;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.androidapps.guti.teameventsmanager.R;

import java.util.Date;

/**
 * Created by ramiro.a.gutierrez on 1/16/2018.
 */

public class NewEventScreenManager {
    private ImageButton ibtnGetTime;
    private ImageButton ibtnGetDate;
    private EditText editEventName;
    private EditText editEventDate;
    private EditText editEventStartTime;
    private EditText editEventDescription;
    private Button btnEventSave;

    public NewEventScreenManager(View view){
        editEventDate = (EditText)view.findViewById(R.id.editEventDate);
        editEventDescription = (EditText)view.findViewById(R.id.editEventDescription);
        editEventName = (EditText)view.findViewById(R.id.editEventName);
        editEventStartTime = (EditText)view.findViewById(R.id.editEventStartTime);
        btnEventSave = (Button)view.findViewById(R.id.btnEventSave);
        ibtnGetDate = (ImageButton)view.findViewById(R.id.ibtnGetDate);
        ibtnGetTime = (ImageButton)view.findViewById(R.id.ibtnGetTime);

    }

    public void setButtonListener(View.OnClickListener listener){
        if (btnEventSave != null)
            btnEventSave.setOnClickListener(listener);
        if (ibtnGetDate != null)
            ibtnGetDate.setOnClickListener(listener);
        if (ibtnGetTime != null)
            ibtnGetTime.setOnClickListener(listener);
    }

    public String getEventName(){
        return editEventName.getText().toString();
    }
    public String getEventDate(){
        return editEventDate.getText().toString();
    }
    public String getEventStartTime(){
        return editEventStartTime.getText().toString();
    }
    public String getEventDescription(){
        return editEventDescription.getText().toString();
    }

    public void setEventDate(String date) {
        editEventStartTime.setText(date);
    }

    public void setEventTime(String time) {
        editEventDate.setText(time);
    }
}
