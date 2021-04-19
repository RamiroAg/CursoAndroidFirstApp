package com.example.ernesto.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt;
        txt = (TextView)findViewById(R.id.pepito);
        txt.setText("hola desde codigo java");

        // asigno evento a boton
        Button btn = (Button)findViewById(R.id.button);

        MyListener listener = new MyListener(txt);
        //MyListener2 listener2 = new MyListener2(this);
        //View.OnClickListener listenerComoInterfaz;
        //listenerComoInterfaz = listener;



        // conecto boton con my obj
        btn.setOnClickListener(listener);

    }


}
