package com.androidapps.guti.firstapp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Created by android on 05/09/17.
 */

public class MyListener implements View.OnClickListener {

    private TextView txt;
    private int counterValue;


    //Recibo el activity para manipular toda la vista como se me antoje
    public MyListener(TextView textView){
        this.txt = textView;
        counterValue = 0;
    }

    @Override
    public void onClick(View view) {
        counterValue++;
        txt.setText(String.valueOf(counterValue));
    }
}




