package com.androidapps.guti.teameventsmanager.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 1/3/2018.
 */
//Clase que se encarga de mostrar e intercambiar fragments
public class HomeFragment extends Fragment {

    public HomeController controller;
    public HomeScreenManager screenManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_main, container,false);
        screenManager = new HomeScreenManager(v);
        controller = new HomeController(screenManager, getActivity());
        //Al fragment le paso datos a través de un bundle
//        Bundle args = getArguments();
        //Hacer algo con los argumentos recibidos, si son necesarios

        return v;
    }
}
