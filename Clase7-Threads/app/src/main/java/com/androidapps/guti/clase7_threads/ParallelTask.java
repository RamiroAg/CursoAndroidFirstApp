package com.androidapps.guti.clase7_threads;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by android on 10/10/17.
 */

public class ParallelTask extends Thread {
    public boolean flagContinue;
    public TextView txt;
    public Handler myHandler;

    public ParallelTask(Handler handler){
        flagContinue = true;
        myHandler = handler;
    }

    @Override
    public void run() { //Sobreescribo para indicar que ejetucará el hilo al ejecutarse
//        for (int i = 0 ; i < 1000 ; i++){
//            Log.d("Thread Message", "Hola " + i);
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        int i = 0;
        while(flagContinue){
            Log.d("Thread Message", "Hola " +  i);
            //txt.setText("Hola " +  i); Remplazo esta línea por el envío del mensaje hacia el hilo ppal

            //Envío del mensaje
            Message msg = new Message();
            msg.arg1 = 0;   //Uso estos dos enteros para identificar el contenido de Object y poder castearlo en el receptor ya que recibo en el mismo handler, mensajes de diferentes threads
            msg.arg2 = 0;
            msg.obj = "Hola " +  i;
            //No se puede reutilizar el objeto Message, por cada mensaje a enviar se debe crear uno nuevo

            myHandler.sendMessage(msg);

            i++;
            try {
                Thread.sleep(1000); //El bloque try catch se exige para poder interrumpir el sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //LIMITACIÓN: sólo el thread de gráfica puede modificar los elementos en pantalla
        //Otro hilo que lo intente generará una excepción
    }
}
