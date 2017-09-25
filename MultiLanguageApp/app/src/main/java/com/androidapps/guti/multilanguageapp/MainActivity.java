package com.androidapps.guti.multilanguageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txt1 =  (TextView) findViewById(R.id.txt1);
        ImageView img =  (ImageView) findViewById(R.id.imageView);
        img.setImageDrawable(R.drawable.Anakin);
    }
}
