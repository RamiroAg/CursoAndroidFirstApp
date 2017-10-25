package com.example.emilianorodriguez.ejerciciorss;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.emilianorodriguez.ejerciciorss.comm.ThreadConexion;
import com.example.emilianorodriguez.ejerciciorss.datos.ParserNoticias;
import com.example.emilianorodriguez.ejerciciorss.entities.Noticia;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  Handler.Callback {

    private List<Noticia> listaNoticias;
    private ScreenManager sm;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Agregar handler y pasarlo en el constructor del hilo
        handler = new Handler(this);

        ThreadConexion tc = new ThreadConexion("http://rss.cnn.com/rss/edition.rss", false, handler);
        Thread t = new Thread(tc);
        t.start();


        sm = new ScreenManager(this);
    }


    @Override
    public boolean handleMessage(Message msg) {

        switch (msg.arg1) {
            case 0: {

                break;
            }
            case 1: // llego una imagen
            {
                Log.d("activity","Recibiendo bytes (imagen)");
                int index = msg.arg2;
                Noticia noticia = listaNoticias.get(index);
                // Cargar imagen en imageview
                byte[] byteArray = (byte[])msg.obj;

                Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                noticia.setBitmap(bmp);
                sm.refresco();
                break;
            }
            case 2: // llego un string
            {
                String dataXml = (String) msg.obj;
                Log.d("act", "llego:" + dataXml);

                ParserNoticias parser = new ParserNoticias(dataXml);
                listaNoticias = parser.parseListaNoticias(); //Devuelve una lista de noticias SIN las fotos, a lo sumo trae un link  a cada una
                Log.d("Largo de lista", String.valueOf(listaNoticias.size()));

                //Recorro la lista de noticias para cargar las imágenes en cada una
                //Remplazar creación de 50 threads por pool de threads
                int i = 0;
                for (Noticia n : listaNoticias){
                    ThreadConexion tc = new ThreadConexion(n.getImageUrl(), true, handler);
                    tc.setExtraData(i);
                    i++;
                    Thread t = new Thread(tc);
                    t.start();
                }

                sm.mostrarLista(listaNoticias);

                break;
            }
        }

        return false;
    }
}
