package com.androidapps.guti.teameventsmanager.events;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidapps.guti.teameventsmanager.MainActivity;
import com.androidapps.guti.teameventsmanager.R;

import java.util.ArrayList;

/**
 * Created by Ramiro on 20/11/2017.
 */

public class MainEventsController implements View.OnClickListener{
    private EventsScreenManager screenManager;
    private ArrayList<Fragment> fragmentCollection;
    private MainActivity activity;

    public MainEventsController(){}

    public MainEventsController(EventsScreenManager screenManager, Activity activity)
    {
        this.screenManager = screenManager;
        this.fragmentCollection = new ArrayList<Fragment>();
        this.fragmentCollection.add(new HomeFragment());
        this.activity = (MainActivity) activity;

        this.screenManager.setButtonListener(this);
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        switch(btn.getId()){
            case R.id.btnNewEvent:
                activity.showFragment(2);
                break;
            default:
                activity.showFragment(2);
                break;
        }
    }
}
