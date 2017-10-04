package com.androidapps.guti.clase6_controldinamico;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 03/10/17.
 */

public class RecyclerviewAdapter extends Adapter{
    private ArrayList<Persona> personaList;
    private MainActivity activity;

    public RecyclerviewAdapter(ArrayList<Persona> list, MainActivity activity){
        personaList = list;
        this.activity = activity;
    }

    @Override       //Paso 2 => devuelve una view vacía
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //A partir de un archivo xml devuelve un objeto
        //El viewHolder posee un atributo view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        //No se puede instanciar un viewHolder => es clase abstracta
        //RecyclerView.ViewHolder vHolder = new MyViewHolder(v);

        //Agregado una vez corregido el código => se adapto VH para que guarde una referencia de C/U de los controles
        RecyclerView.ViewHolder vHolder = new MyViewHolder(v, activity);

        return vHolder;
    }

    @Override       //Paso 3 => Carga la view con información y la devuelve
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Persona p = personaList.get(position);

        //Busco acceder a cada uno de los 3 elementos en la vista de cada ítem (esto está mal)
        View v = holder.itemView;
//        TextView txtNombre = (TextView) v.findViewById(R.id.txtNombre);   //Hacer findViewById es costoso, no está bueno ir a buscar controles todo el tiempo
//        TextView txtApellido = (TextView) v.findViewById(R.id.txtApellido);
        //Guardo las referencias de los controles dentro del viewHolder => esa sí es buena práctica papá!!!

        MyViewHolder mvh = (MyViewHolder)holder;    //Está mal también
        TextView txtNombre = mvh.txtNombre;
        TextView txtApellido = mvh.txtApellido;

        //Seteo propiedades como en cualquier otro caso
        txtNombre.setText(p.getNombre());
        txtApellido.setText(p.getApellido());


    }

    @Override       //Paso 1
    public int getItemCount() {
        return personaList.size();
    }
}
