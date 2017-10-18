package com.example.ernesto.ejhttpparacompletar2017;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ThreadConexion implements Runnable{

    private String url;
    private boolean flagBytesString;
    private Handler handler;

    /*	Recibimos un Handler, la URL y un flag que indica si leemos bytes o String
     *
     */
    public ThreadConexion(String url,boolean flagBytesString, Handler myhandler)
    {
        this.url = url;
        this.flagBytesString=flagBytesString;
        this.handler = myhandler;
    }

    /*
     * Metodo run del thread, se conecta a la url y recupera los datos que envio por el handler
     *
     */
    public void run() {
        //Como buena práctica se puede definir tódo este código dentro de un for con 4, 5 intentos en caso de la conexion a internet no funcione
        Message msg = new Message();

        HttpManager httpManager = new HttpManager(url);
        try{

            if(flagBytesString)
            {
                byte[] bytesRespuesta;
                bytesRespuesta = httpManager.getBytesDataByGET();
                // cargar respuesta en mensaje
                msg.arg1 = 1;
                msg.obj = bytesRespuesta;
            }
            else
            {
                String strRespuesta;
                strRespuesta = httpManager.getStrDataByGET();
                // cargar respuesta en mensaje
                msg.arg1 = 2;
                msg.obj = strRespuesta;
            }
            handler.sendMessage(msg);

        }catch(Exception e)
        {
            Log.d("http","ERROR");
            msg.arg1=0;
        }

        // Enviar mensaje
    }



}
