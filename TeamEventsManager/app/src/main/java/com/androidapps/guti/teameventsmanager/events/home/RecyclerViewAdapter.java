package com.androidapps.guti.teameventsmanager.events.home;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapps.guti.teameventsmanager.MainActivity;
import com.androidapps.guti.teameventsmanager.Model.Event;
import com.androidapps.guti.teameventsmanager.R;

import java.util.ArrayList;

/**
 * Created by ramiro.a.gutierrez on 1/21/2018.
 */

public class RecyclerViewAdapter extends Adapter<EventViewHolder> {
    private ArrayList<Event> eventList;
    private MainActivity activity;

    public RecyclerViewAdapter(ArrayList<Event> eventList, MainActivity activity){
        this.eventList = eventList;
        this.activity = activity;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);

        EventViewHolder vHolder = new EventViewHolder(v, activity);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = eventList.get(position);

        //Cargo info
        TextView txtEventName = holder.txtEventName;
        TextView txtEventDescription = holder.txtEventDescription;

        //Seteo propiedades como en cualquier otro caso
        txtEventName.setText(event.name);
        txtEventDescription.setText(event.description);


        //Me guardo la posición
        holder.elementPosition = position;
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
