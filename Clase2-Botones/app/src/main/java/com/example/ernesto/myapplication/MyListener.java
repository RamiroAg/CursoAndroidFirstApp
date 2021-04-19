package com.example.ernesto.myapplication;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ernesto on 05/09/17.
 */

public class MyListener implements View.OnClickListener{

    private TextView t;
    int c;
    // escribo un constr que reciba el textview
    public MyListener(TextView t)
    {
        this.t=t;
        c=0;
    }


    @Override
    public void onClick(View view) {
        Log.d("MyListener","Se hizo click!");
        this.t.setText("Hiciste click, mira como programo android");
        c++;
        this.t.setText("contador:"+c);

    }
}
