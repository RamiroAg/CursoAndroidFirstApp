package com.androidapps.guti.teameventsmanager.events;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 12/6/2017.
 */
//Acá se manipulan todos los controles de interfaz
public class EventsScreenManager {

    private FloatingActionButton btnNewEvent;

    public EventsScreenManager (View v){
        btnNewEvent = (FloatingActionButton) v.findViewById(R.id.fab);     //Seteo el FAB como botón para crear eventos
    }

    public void setButtonListener(View.OnClickListener listener)
    {
        if(btnNewEvent != null)
            btnNewEvent.setOnClickListener(listener);
    }
}
