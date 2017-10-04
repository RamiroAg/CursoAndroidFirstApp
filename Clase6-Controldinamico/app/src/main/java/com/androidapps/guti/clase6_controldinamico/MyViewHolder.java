package com.androidapps.guti.clase6_controldinamico;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by android on 03/10/17.
 */

//Clase que hereda de la clase abstracta ViewHolder (Se implementa en el segundo mensaje del adapter)
public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public int elementPosition;
    public TextView txtNombre;
    public TextView txtApellido;
    private MainActivity activity;

    public MyViewHolder(View itemView, MainActivity a) {
        super(itemView);
        itemView.setOnClickListener(this);  //Seteo el onclickListener a la view entera

        txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        txtApellido = (TextView) itemView.findViewById(R.id.txtApellido);

        activity = a;
        //Dentro del constructor crear el onClickListener
    }

    @Override
    public void onClick(View view) {
        activity.hayEventoOnClick(elementPosition);
    }
}
