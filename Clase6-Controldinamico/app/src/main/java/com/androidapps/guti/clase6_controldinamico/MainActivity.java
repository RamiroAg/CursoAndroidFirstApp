package com.androidapps.guti.clase6_controldinamico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persona persona1 = new Persona("Ramiro", "Gutiérrez");
        Persona persona2 = new Persona("Rick", "Sánchez");
        Persona persona3 = new Persona("Tu", "Hermana");
        Persona persona4 = new Persona("Ramiro1", "Gutiérrez1");
        Persona persona5 = new Persona("Ramiro2", "Gutiérrez2");
        Persona persona6 = new Persona("Ramiro3", "Gutiérrez3");
        Persona persona7 = new Persona("Ramiro4", "Gutiérrez4");

        ArrayList<Persona> personaList = new ArrayList<Persona>();
        personaList.add(persona1);
        personaList.add(persona2);
        personaList.add(persona3);
        personaList.add(persona4);
        personaList.add(persona5);
        personaList.add(persona6);
        personaList.add(persona7);

        for (int i = 0 ; i < 100 ; i++){
            personaList.add(new Persona("Ramiro " + i, "Guti " + i));
        }

        RecyclerAdapterBueno adapter = new RecyclerAdapterBueno(personaList, this);

        //Traer el RV, crear adapter, asociar adapter
        RecyclerView rv = (RecyclerView) findViewById(R.id.personRV);
        rv.setAdapter(adapter);
        //Para indicarle al RV si mostrar objetos como lista o grilla necesito usar un Layout Manager
//        rv.setLayoutManager(new LinearLayoutManager(this));

        //Pruebo mostrarlo como grilla
        rv.setLayoutManager(new GridLayoutManager(this, 2));
    }

    public void hayEventoOnClick(int elementPosition) {
        Log.d("GUTI Log", "Se hizo click en elemento: " + elementPosition);
    }
}
