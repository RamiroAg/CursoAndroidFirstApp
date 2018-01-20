package com.androidapps.guti.teameventsmanager.events;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapps.guti.teameventsmanager.Model.Event;
import com.androidapps.guti.teameventsmanager.R;
import com.androidapps.guti.teameventsmanager.ScreenSlidePagerAdapter;
import com.androidapps.guti.teameventsmanager.home.HomeController;
import com.androidapps.guti.teameventsmanager.home.HomeScreenManager;

import java.util.ArrayList;

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

        //Events viewPager
        ViewPager pager = (ViewPager)v.findViewById(R.id.eventsPager);
        PagerAdapter adapter = new ScreenSlidePagerAdapter(getChildFragmentManager()); //getChildFragmentManager() se usa cuando se necesita un fragmentManager desde un fragment y no desde un Activity
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)controller.activity.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);    //Atacheo el comportamiento del tab al del pager

//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE); //Indico que los tabs son scrolleables
        tabLayout.setTabMode(TabLayout.MODE_FIXED); //Indico que los tabs quedan fijos

        ArrayList<Event> eventList = controller.activity.eventDao.getAllEvents();

        return v;
    }
}
