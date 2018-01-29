package com.androidapps.guti.teameventsmanager.events.home;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.View;

import com.androidapps.guti.teameventsmanager.MainActivity;

import java.util.ArrayList;

/**
 * Created by Ramiro on 20/11/2017.
 */

public class HomeController implements View.OnClickListener{
    private EventsScreenManager screenManager;
    private ArrayList<Fragment> fragmentCollection;
    public MainActivity activity;
    public android.support.v4.app.FragmentManager fragmentManager;

    public HomeController(){}

    public HomeController(EventsScreenManager screenManager, Activity activity)
    {
        this.screenManager = screenManager;
        this.fragmentCollection = new ArrayList<Fragment>();
        this.fragmentCollection.add(new HomeFragment());
        this.activity = (MainActivity) activity;
        this.fragmentManager = this.activity.fragmentManager;

        this.screenManager.setButtonListener(this);
    }

    @Override
    public void onClick(View view) {
        FloatingActionButton btn = (FloatingActionButton) view;
        switch(btn.getId()){
//            case R.id.btnNewEvent:
//                activity.showFragment(2);
//                break;
            default:
                activity.showFragment(2);
                break;
        }
    }
}
