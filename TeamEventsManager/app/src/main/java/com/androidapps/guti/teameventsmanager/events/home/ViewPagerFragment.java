package com.androidapps.guti.teameventsmanager.events.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapps.guti.teameventsmanager.MainActivity;
import com.androidapps.guti.teameventsmanager.Model.DataAccess.EventManagerDao;
import com.androidapps.guti.teameventsmanager.Model.DataAccess.JsonDao;
import com.androidapps.guti.teameventsmanager.Model.Event;
import com.androidapps.guti.teameventsmanager.R;

import java.util.ArrayList;

/**
 * Created by ramiro.a.gutierrez on 1/7/2018.
 */

public class ViewPagerFragment extends Fragment {

    public HomeController controller;
    public MainActivity activity;

    public ViewPagerFragment(){

    }
//    public ViewPagerFragment(HomeController controller){
//        this.controller = controller;
//    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.events_viewpager_layout, container, false);


        this.activity = (MainActivity) getActivity();
        EventManagerDao eventDao = JsonDao.getInstance(this.activity);
        ArrayList<Event> eventList = eventDao.getAllEvents();

        RecyclerViewAdapter rvAdapter = new RecyclerViewAdapter(eventList, this.activity);

        //Traer el RV, crear adapter, asociar adapter
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.rv_events);
        rv.setAdapter(rvAdapter);
        //Para indicarle al RV si mostrar objetos como lista o grilla necesito usar un Layout Manager
//        rv.setLayoutManager(new LinearLayoutManager(this));
//
//        //Pruebo mostrarlo como grilla
//        rv.setLayoutManager(new GridLayoutManager(controller.activity, 2));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.activity);
        rv.setLayoutManager(layoutManager);
        return v;
    }
}
