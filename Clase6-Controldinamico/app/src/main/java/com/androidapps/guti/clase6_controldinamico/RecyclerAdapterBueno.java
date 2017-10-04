package com.androidapps.guti.clase6_controldinamico;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 03/10/17.
 */

public class RecyclerAdapterBueno extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Persona> personaList;
    private MainActivity activity;

    public RecyclerAdapterBueno(ArrayList<Persona> list, MainActivity activity){
        personaList = list;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        MyViewHolder vHolder = new MyViewHolder(v, activity);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Persona p = personaList.get(position);

        //Cargo info
        TextView txtNombre = holder.txtNombre;
        TextView txtApellido = holder.txtApellido;

        //Seteo propiedades como en cualquier otro caso
        txtNombre.setText(p.getNombre());
        txtApellido.setText(p.getApellido());


        //Me guardo la posición
        holder.elementPosition = position;
    }

    @Override
    public int getItemCount() {
        return personaList.size();
    }
}
