package com.androidapps.guti.teameventsmanager.events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 1/7/2018.
 */

public class ViewPagerFragment extends Fragment {

    private String message;
    public ViewPagerFragment(){

    }
    public ViewPagerFragment(String message){
        this.message = message;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.events_viewpager_layout, container, false);
        TextView txtPageSubtitle = (TextView)v.findViewById(R.id.textView5);
        txtPageSubtitle.setText(this.message);
        return v;
    }
}
