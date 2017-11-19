package com.androidapps.guti.clase12_broadcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsMessage;
import android.util.Log;

public class GutiBR extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Leo el contenido del sms
        Bundle info = intent.getExtras();
        if(info!=null){
            Object[] pduArray = (Object[]) info.get("pdus"); //Obtengo datos con formato del SMS. Busco el value asociado a la clave "pdus"
            //Cada elemento del array de object es un SMS, un array de bytes-

            SmsMessage[] messages = new SmsMessage[pduArray.length];
            for(int i=0;i<pduArray.length;i++)
            {
                //Depende de la versión de android se usa un método u otro. .createFromPdu está deprecado para el SDL >= 19
                //Puedo evaluarlo con un if para evaluar la versión.
                //Deserializo el sms
                messages[i]=SmsMessage.createFromPdu((byte[])pduArray[i]);
                Log.d("br","Msg de:"+messages[i].getOriginatingAddress());
                Log.d("br","Texto:"+messages[i].getMessageBody());

                //Lanzo notificación
                NotificationManager mNotificationManager = (NotificationManager)
                        context.getSystemService(Context.NOTIFICATION_SERVICE);

                int icon = R.mipmap.ic_launcher;
                String tickerText = "Evento de sms";    //Texto que aparece cuando la barra de notificaciones está cerrada
                long when = System.currentTimeMillis(); //Cuándo quiero lanzar la notificación (AHORAAAA)

                CharSequence contentTitle = "SMS";          //Texto que se mostrará al desplegar la barra. Se pueden agregar botones con un builder
                CharSequence contentText = "Evento de sms";

                //Al tocar la notificación se tiene que larzar un activity a través de un intent. Sería un intent común
                //Cómo los que se usan para mostrar una nueva activity
                Intent notificationIntent = new Intent(context,MainActivity.class);
                //El pending intent permite lanzar un intent cuando el user toque en la notificación.
                // El PI se puede lanzar en nombre de otro, con los permisos de quién generó el Intent que contiene.
                //Un intent puede guardar datos
                PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder  builder = new NotificationCompat.Builder(context);

                Notification notification = builder.setContentIntent(contentIntent)
                        .setSmallIcon(icon)
                        .setTicker(tickerText)
                        .setWhen(when)
                        .setAutoCancel(true)
                        .setContentTitle(contentTitle)
                        .setContentText(contentText)
                        .build();

                mNotificationManager.notify(0, notification);

            }
        }

    }
}
