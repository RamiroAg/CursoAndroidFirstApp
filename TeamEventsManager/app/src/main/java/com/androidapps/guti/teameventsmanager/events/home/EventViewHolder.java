package com.androidapps.guti.teameventsmanager.events.home;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.androidapps.guti.teameventsmanager.MainActivity;
import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by ramiro.a.gutierrez on 1/21/2018.
 */
//Clase que hereda de la clase abstracta ViewHolder (Se implementa en el segundo mensaje del adapter)
public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public int elementPosition;
    public TextView txtEventName;
    public TextView txtEventDescription;
    private MainActivity activity;

    public EventViewHolder(View itemView, MainActivity activity) {
        super(itemView);
        itemView.setOnClickListener(this);  //Seteo el onclickListener a la view entera

        txtEventName = (TextView) itemView.findViewById(R.id.lbl_event_item_name);
        txtEventDescription = (TextView) itemView.findViewById(R.id.lbl_event_item_desc);

        this.activity = activity;
        //Dentro del constructor crear el onClickListener
    }

    @Override
    public void onClick(View view) {
        Log.d("Event RecyclerView", "Evento n° " + elementPosition + " presionado");
    }
}
