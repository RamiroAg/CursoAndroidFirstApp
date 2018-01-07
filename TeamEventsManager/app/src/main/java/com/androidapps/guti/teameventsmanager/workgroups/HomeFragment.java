package com.androidapps.guti.teameventsmanager.workgroups;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapps.guti.teameventsmanager.R;
import com.androidapps.guti.teameventsmanager.events.EventsScreenManager;
import com.androidapps.guti.teameventsmanager.events.MainEventsController;

/**
 * Created by ramiro.a.gutierrez on 1/6/2018.
 */

public class HomeFragment extends Fragment {
    public WorkgroupsScreenManager screenManager;
    public WorkgroupsHomeController controller;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.workgroups_main, container,false);
        screenManager = new WorkgroupsScreenManager(v);
        controller = new WorkgroupsHomeController(screenManager, getActivity());
        //Al fragment le paso datos a través de un bundle
//        Bundle args = getArguments();
        //Hacer algo con los argumentos recibidos, si son necesarios

        return v;
    }
}
