package com.androidapps.guti.clase12_firebasecloudmessaging;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public MyFirebaseMessagingService() {
    }

    //Método que escucha los mensajes cuando la app esté abierta
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("Message Firebase", "From: " + remoteMessage.getFrom());

        //El mensaje puede tener un dataPayload, que es un JSON

// Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d("Message Firebase", "Message data payload: " + remoteMessage.getData());
        }
// Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d("Message Firebase", "Message Notification Body: " +
                    remoteMessage.getNotification().getBody());
        }
    }
}
