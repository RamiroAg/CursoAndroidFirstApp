package com.androidapps.guti.teameventsmanager.events.newEvent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.androidapps.guti.teameventsmanager.R;
import com.androidapps.guti.teameventsmanager.Services.CommonServices;

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
    public Date  getEventDate(){
        return CommonServices.getDateFromString(editEventDate.getText().toString());
    }
    public Date getEventStartTime(){
        return CommonServices.getTimeFromString(editEventStartTime.getText().toString());
    }
    public String getEventDescription(){
        return editEventDescription.getText().toString();
    }

    public void setEventDate(String date) {
        editEventDate.setText(date);
    }

    public void setEventTime(String time) {
        editEventStartTime.setText(time);
    }
}
