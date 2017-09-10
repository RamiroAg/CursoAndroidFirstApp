package com.androidapps.guti.firstapp;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by android on 05/09/17.
 */

public class EventListeners implements OnClickListener{

    private TextView txt;

    public EventListeners(TextView txtControl){
        this.txt = txtControl;
    }

    @Override
    public void onClick(View view) {    //Este view es el botón que generó el evento
        Button btnSubmit = (Button)view.findViewById(R.id.btnSubmit);

        /*if (btnSubmit.getText() == R.string.btnSubmitText)
            btnSubmit.setText(R.string.btnSubmitText2);
        else
            btnSubmit.setText(R.string.btnSubmitText);*/
        /*TextView txt1 = (TextView) view.findViewById(R.id.textView);
        txt1.setText(R.string.txtText1);*/
        /*if (txt.getText() != R.string.txtText1)
            txt.setText(R.string.txtText1);*/
        //el string dentro del recurso se debe obtener desde el activity

        Log.d("EventListener", "Clickeaste el botón papu");
    }
}
