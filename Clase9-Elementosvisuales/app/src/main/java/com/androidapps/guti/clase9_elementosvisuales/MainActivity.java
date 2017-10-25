package com.androidapps.guti.clase9_elementosvisuales;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //Traigo la toolbar
        setSupportActionBar(toolbar);   //Indico que será utilizada como action bar (antes el widget se llamaba actionbar)

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);   //Traigo el botón flotante
        //Usa clase anónima, seteo un onClickListener al botón
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG) //Lanzo el dialoguito que aparece debajo
                        .setAction("Action", null).show();
            }
        });*/

    }

    //Métodos asociados al menú del activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu); //Agrega elementos de menú desde xml
        return true;
    }

    //Método que se ejecuta al clickear sobre un ítem de menú, indica que ítem fue clickeado
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.d("Menu event", "Click en Settings");
            return true;
        }
        else if (id == R.id.Opcion1){
            Log.d("Menu event", "Click en Opcion1");
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);    //Recibe un objeto context
//            builder.setTitle("Alerta!");
//            builder.setMessage("Mensaje de alerta");
//
//            builder.setPositiveButton("Aceptar", null); //This debe implementar el evento que usa para escuchar el click
//            //Si no tiene lístener, cada botón creado cierra la popup
//            //Se pueden agregar diferentes tipos de botones
//            //Si no tuviese botón, se sale con BACK
//            builder.setCancelable(false); //No sale al presionar back
//            // Creamos el dialogo
//            AlertDialog ad = builder.create();
//            ad.show();  //No se hace esto, así no se lanza ahora (antes si)

            GutiDialog dialog = new GutiDialog();
            Bundle b = new Bundle();
            b.putString("title", "Alert!");
            b.putString("message", "Mensaje de alerta, entre en pánico.");
            dialog.setArguments(b);
            dialog.setListener(this);
            dialog.show(getSupportFragmentManager(), "dialog"); //Necesito un fragment manager
        }
        else if (id == R.id.Opcion2){
            Log.d("Menu event", "Click en Opcion2");
        }
        else if (id == R.id.Opcion3){
            Log.d("Menu event", "Click en Opcion3");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Log.d("Activity", "Click on dialog button: " + i);

    }
}
