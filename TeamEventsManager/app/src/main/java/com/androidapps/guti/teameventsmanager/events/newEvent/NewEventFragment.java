package com.androidapps.guti.teameventsmanager.events.newEvent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 1/5/2018.
 */

public class NewEventFragment extends Fragment {
    public NewEventController controller;
    public NewEventScreenManager screenManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.events_new, container,false);
        screenManager = new NewEventScreenManager(v);
        controller = new NewEventController(screenManager, getActivity());
        //Al fragment le paso datos a través de un bundle
//        Bundle args = getArguments();
        //Hacer algo con los argumentos recibidos, si son necesarios

        return v;
    }
}
