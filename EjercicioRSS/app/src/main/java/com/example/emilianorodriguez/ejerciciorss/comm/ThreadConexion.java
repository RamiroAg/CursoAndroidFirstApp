package com.example.emilianorodriguez.ejerciciorss.comm;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ThreadConexion implements Runnable{

    private String url;
    private boolean flagBytesString;
    private Handler handler;

    private int extraData;

    /*	Recibimos un Handler, la URL y un flag que indica si leemos bytes o String
     *
     */
    public ThreadConexion(String url,boolean flagBytesString, Handler handler)
    {
        this.url = url;
        this.flagBytesString=flagBytesString;
        this.handler = handler;
    }

    /*
     * Metodo run del thread, se conecta a la url y recupera los datos que envio por el handler
     *
     */
    public void run() {


        Message msg = new Message();

        HttpManager httpManager = new HttpManager(url);
        try{

            if(flagBytesString)
            {
                byte[] bytesRespuesta;
                bytesRespuesta = httpManager.getBytesDataByGET();
                msg.arg1=1;
                msg.obj=bytesRespuesta;
            }
            else
            {
                String strRespuesta;
                strRespuesta = httpManager.getStrDataByGET();
                msg.arg1=2;
                msg.obj=strRespuesta;
            }

        }catch(Exception e)
        {
            Log.d("http","ERROR");
            e.printStackTrace();
            msg.arg1=0;
        }

        // enviar el mensaje por el handler
        msg.arg2 = extraData;
        handler.sendMessage(msg);

    }

    public void setExtraData(int extraData)
    {
        this.extraData=extraData;
    }

}
