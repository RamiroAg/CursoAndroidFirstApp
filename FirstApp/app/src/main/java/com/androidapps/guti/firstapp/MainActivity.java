package com.androidapps.guti.firstapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    /*private View.OnClickListener btnSubmitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
            btnSubmit.setText(R.string.btnSubmitText);
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {    //equivalente al main, punto de entrada a la app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Indica que vista debe utilizar este code behind
        //Todo el código debe ir debajo de esta instrución
        //Clase R => hace referencia de los objetos XML dentro de Resources

        //Todos los objetos en pantalla heredan de la clase View
        //Para obtener un objeto siempre tengo que castearlo al control correspondiente
        TextView txt1 = (TextView) findViewById(R.id.textView);
        txt1.setText("Hola Guti");
        //Sólo traerá el control con id "textView" que se encuentre dentro de la vista "activity_main"

        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setText(R.string.btnSubmitText);
        EventListeners listener = new EventListeners(txt1);
        btnSubmit.setOnClickListener(listener); //Asocio el listener del evento al control

    //TODO: implementar un contador
        int counter = 0;
        //Button btnDecrease = (Button) findViewById(R.id.btnDecreaseCounter);
        //btnDecrease.setText(R.string.btnDecreaseText);
        //MyListener increaseListener = new MyListener(txt1);

        Button btnIncrease = (Button) findViewById(R.id.btnIncreaseCounter);
        btnIncrease.setText(R.string.btnIncreaseText);
        btnIncrease.setOnClickListener(new MyListener(txt1));
    }


}
