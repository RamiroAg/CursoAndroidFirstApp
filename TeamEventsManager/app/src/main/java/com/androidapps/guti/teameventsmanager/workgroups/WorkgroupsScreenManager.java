package com.androidapps.guti.teameventsmanager.workgroups;

import android.view.View;
import android.widget.Button;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 1/6/2018.
 */

public class WorkgroupsScreenManager {

    private Button btnNewWorkgroup;

    public WorkgroupsScreenManager(View v) {
        btnNewWorkgroup = (Button) v.findViewById(R.id.btnNewWorkgroup);
    }

    public void setButtonListener(View.OnClickListener listener){
        if(btnNewWorkgroup != null)
            btnNewWorkgroup.setOnClickListener(listener);
    }
}
