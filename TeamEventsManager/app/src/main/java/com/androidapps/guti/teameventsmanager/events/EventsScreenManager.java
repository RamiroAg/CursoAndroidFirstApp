package com.androidapps.guti.teameventsmanager.events;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 12/6/2017.
 */
//Acá se manipulan todos los controles de interfaz
public class EventsScreenManager {

    private Button btnNewEvent;

    public EventsScreenManager (View v){
        btnNewEvent = (Button)v.findViewById(R.id.btnNewEvent);
    }

    public void setButtonListener(View.OnClickListener listener)
    {
        if(btnNewEvent != null)
            btnNewEvent.setOnClickListener(listener);
    }
}
