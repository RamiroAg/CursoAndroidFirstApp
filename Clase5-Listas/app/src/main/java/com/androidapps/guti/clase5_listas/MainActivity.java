package com.androidapps.guti.clase5_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Model model = new Model();
        model.listaStrings.add("01 - Item 1");
        model.listaStrings.add("02 - Item 2");
        model.listaStrings.add("03 - Item 3");

        for (String nombre : model.listaStrings){
            Log.d("Main Activity", "Nombre: " + nombre);
        }

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, model.listaStrings);
        //El tipo del adapter deberá coincidir con el tipo de elementos de la lista que paso como parámetro
        //Primer parámetro: el activity, segundo: un layout que tenga adentro el textview que va a mostrar el control
        //Uso un R que provee una api de android para traer el layout que necesito

        spinner.setAdapter(adapter);
    }
}
