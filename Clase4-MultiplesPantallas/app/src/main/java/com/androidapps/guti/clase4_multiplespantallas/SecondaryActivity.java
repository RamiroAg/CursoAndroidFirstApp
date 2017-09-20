package com.androidapps.guti.clase4_multiplespantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent intent = getIntent(); //obtiene el intent que invocó la vista
        Bundle bundle = intent.getExtras();     //Objeto bundle contendrá la tabla clave-valor que guarda el intent

        TextView txt = (TextView)findViewById(R.id.textView);
        txt.setText(bundle.getString("textToShow"));

    }


}
