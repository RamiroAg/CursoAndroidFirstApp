package com.example.ernesto.ejemplomvc;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ernesto on 12/09/17.
 */

public class ScreenManager {

    private TextView t;
    private Button b;
    public ScreenManager(Activity a)
    {
        t = (TextView)a.findViewById(R.id.txt);
        b = (Button)a.findViewById(R.id.button);
    }

    public void showNumber(int number)
    {
        t.setText(String.valueOf(number));
    }

    public void setButtonListener(View.OnClickListener listener)
    {
        b.setOnClickListener(listener);
    }
}
