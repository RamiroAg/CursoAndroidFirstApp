package com.androidapps.guti.teameventsmanager.home;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.androidapps.guti.teameventsmanager.MainActivity;
import com.androidapps.guti.teameventsmanager.events.EventsScreenManager;


/**
 * Created by ramiro.a.gutierrez on 12/29/2017.
 */

public class HomeController implements View.OnClickListener{
    private HomeScreenManager screenManager;
    private MainActivity activity;

    public HomeController(){}

    public HomeController(HomeScreenManager screenManager, Activity activity){
        this.screenManager = screenManager;
        this.screenManager.setButtonListener(this);
        this.activity = (MainActivity) activity;
    }

    @Override
    public void onClick(View view) {
        Log.d("Evento", "btnEventsMenu presionado");
        activity.showFragment(1);
    }
}
