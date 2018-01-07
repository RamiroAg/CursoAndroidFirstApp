package com.androidapps.guti.teameventsmanager.home;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 12/29/2017.
 */

public class HomeScreenManager {

    private Button btnEventsMenu;
    private Button btnWorkgroupsMenu;

    public HomeScreenManager(View a){
        btnEventsMenu = (Button)a.findViewById(R.id.btnEventsMenu);
        btnWorkgroupsMenu = (Button)a.findViewById(R.id.btnWorkgroupsMenu);
    }

    public void setButtonListener(View.OnClickListener listener)
    {
        if(btnEventsMenu != null)
            btnEventsMenu.setOnClickListener(listener);
        if(btnWorkgroupsMenu != null)
            btnWorkgroupsMenu.setOnClickListener(listener);
    }
}
