package com.androidapps.guti.teameventsmanager.workgroups;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 1/6/2018.
 */

public class NewWorkgroupFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.workgroup_new, container,false);

        //Al fragment le paso datos a través de un bundle
//        Bundle args = getArguments();
        //Hacer algo con los argumentos recibidos, si son necesarios

        return v;
    }
}
