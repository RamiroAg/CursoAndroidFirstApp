package com.example.ernesto.ejhttpparacompletar2017;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear handler
        Handler handler = new Handler(this);

        // flag en true para recibir bytes
        //http://icons.iconarchive.com/icons/3xhumed/mega-games-pack-33/256/Borderlands-2-icon.png
        //http://www.lslutnfra.com/alumnos/practicas/ubuntu-logo.png
        ThreadConexion tc = new ThreadConexion("https://img00.deviantart.net/8880/i/2012/359/9/9/borderlands_2_icon_by_xvgojira-d5p74bj.jpg",true, handler);
        Thread t = new Thread(tc);
        t.start();
        //________________________________

        // flag en false para recibir un string
        ThreadConexion tc2 = new ThreadConexion("http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml",false, handler);
        Thread t2 = new Thread(tc2);
        t2.start();
        //_____________________________________
    }

    @Override
    public boolean handleMessage(Message msg) {
        //Desde acá manipulo la pantalla
        switch(msg.arg1)
        {
            case 0:{
                Log.d("activity", "Error");
                break;
            }
            case 1:{
                Log.d("activity","Recibiendo bytes (imagen)");
                // Cargar imagen en imageview
                byte[] byteArray = (byte[])msg.obj;

                Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                ImageView image = (ImageView) findViewById(R.id.imageView);

                image.setImageBitmap(Bitmap.createScaledBitmap(bmp, image.getWidth(),
                        image.getHeight(), false));
                break;
            }
            case 2:{
                Log.d("activity","Recibiendo string (xml)");
                // cargar texto en textView
                TextView txt = (TextView)findViewById(R.id.textView);
                txt.setText(msg.obj.toString());
                break;
            }
        }
        return true;
    }
}
