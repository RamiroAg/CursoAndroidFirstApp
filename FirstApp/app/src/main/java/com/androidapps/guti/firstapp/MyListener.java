package com.androidapps.guti.firstapp;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by android on 05/09/17.
 */

public class MyListener implements View.OnClickListener {

    private View view;

    //Recibo el activity para manipular toda la vista como se me antoje
    public MyListener(View currentView){
        this.view = currentView;
    }

    @Override
    public void onClick(View view) {

    }
}
