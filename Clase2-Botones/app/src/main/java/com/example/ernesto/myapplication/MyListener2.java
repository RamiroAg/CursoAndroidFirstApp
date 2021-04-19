package com.example.ernesto.myapplication;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ernesto on 05/09/17.
 */

public class MyListener2 implements View.OnClickListener {

    private Activity a;
    public MyListener2(Activity a)
    {
        this.a=a;
    }


    @Override
    public void onClick(View view) {
        TextView t = this.a.findViewById(R.id.pepito);
        t.setText("mensaje!");


    }

}
