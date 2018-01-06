package com.androidapps.guti.teameventsmanager.events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapps.guti.teameventsmanager.R;
import com.androidapps.guti.teameventsmanager.home.HomeController;
import com.androidapps.guti.teameventsmanager.home.HomeScreenManager;

/**
 * Created by ramiro.a.gutierrez on 1/5/2018.
 */

public class HomeFragment extends Fragment {
    public MainEventsController controller;
    public EventsScreenManager screenManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.events_main, container,false);
        screenManager = new EventsScreenManager(v);
        controller = new MainEventsController(screenManager, getActivity());
        //Al fragment le paso datos a través de un bundle
//        Bundle args = getArguments();
        //Hacer algo con los argumentos recibidos, si son necesarios

        return v;
    }
}
