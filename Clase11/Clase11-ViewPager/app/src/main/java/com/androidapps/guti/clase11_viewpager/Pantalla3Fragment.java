package com.androidapps.guti.clase11_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by android on 07/11/17.
 */

public class Pantalla3Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        // Creamos la View para este fragment y la devolvemos
        ViewGroup rootView = (ViewGroup)
                inflater.inflate(R.layout.layout_contenido3,
                        container, false);

        // Cargamos la View con contenido, seteamos listeners, etc.
        //...

        return rootView;
    }
}
