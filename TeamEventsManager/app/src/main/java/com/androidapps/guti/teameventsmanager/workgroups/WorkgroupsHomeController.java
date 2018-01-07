package com.androidapps.guti.teameventsmanager.workgroups;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidapps.guti.teameventsmanager.MainActivity;
import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by Ramiro on 20/11/2017.
 */

public class WorkgroupsHomeController implements View.OnClickListener{

    private WorkgroupsScreenManager screenManager;
    private MainActivity activity;

    public WorkgroupsHomeController(WorkgroupsScreenManager screenManager, Activity activity) {
        this.screenManager = screenManager;
        this.activity = (MainActivity) activity;

        this.screenManager.setButtonListener(this);
    }
    //Toda la lógica que iría adentro de un Activity se escribe acá

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        switch(btn.getId()){
            case R.id.btnNewWorkgroup:
                activity.showFragment(4);
                break;
            default:
                activity.showFragment(4);
                break;
        }
    }
}
