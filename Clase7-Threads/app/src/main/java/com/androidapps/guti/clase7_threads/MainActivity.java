package com.androidapps.guti.clase7_threads;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback{
    private ParallelTask hilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear un handler de AndoidOS
        Handler handler = new Handler(this); //En el constructor debo pasar un objeto que escuchará la recepción de los mensajes (equivalente al onClickListener)

        TextView txt = (TextView)findViewById(R.id.txt1);
        hilo = new ParallelTask(handler);

        //hilo.run(); //Nunca llamar a run => hay que lanzarlo
        hilo.start();   //Acá Sí se crea un hilo nuevo con el código definido en Run()


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hilo.flagContinue = false;  //No matar el hilo, llevarlo a su finalización natural
        hilo.interrupt();   //Interrumpe el sleep del hilo
    }


    //Evento en el hilo de la gráfica que está a la constante escucha de recepción de mensajes
    @Override
    public boolean handleMessage(Message message) {
        //Generalmente se implementa un switch para variar el comportamiento ante diferentes mensajes
        String msg = (String)message.obj;
        TextView txt = (TextView)findViewById(R.id.txt1);
        txt.setText(msg);
        return false;
    }
}
