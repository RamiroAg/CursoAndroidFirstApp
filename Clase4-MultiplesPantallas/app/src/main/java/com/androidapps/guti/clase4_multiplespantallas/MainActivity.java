package com.androidapps.guti.clase4_multiplespantallas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) this.findViewById(R.id.button2);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("Main Activity", "Click on button");

        EditText txt = (EditText)findViewById(R.id.editText);
        String textContent = txt.getText().toString();      //Valor que quiero transmitir a la otra Activity

        Intent intent = new Intent(this, SecondaryActivity.class);
        //new Intent(objeto context => se pasa directamente la vista actual,
        //objeto tipo class => acá va la clase de la activity que quiero invocar

        intent.putExtra("textToShow", textContent);

        startActivity(intent);
    }
}
