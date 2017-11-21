package com.androidapps.guti.teameventsmanager.events;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidapps.guti.teameventsmanager.R;

/**
 * Created by Ramiro on 20/11/2017.
 */

public class EventsController extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.events_main, container,false);

        //Al fragment le paso datos a través de un bundle
        Bundle args = getArguments();

//        int idPlaneta = args.getInt("idPlaneta");
//        switch(idPlaneta)
//        {
//            case 0:
//                img.setImageResource(R.drawable.mercurio);
//                txtTitulo.setText(getText(R.string.titulo_mercurio));
//                txtInfo.setText(getText(R.string.info_mercurio));
//                break;
//            case 1:
//                img.setImageResource(R.drawable.venus);
//                txtTitulo.setText(getText(R.string.titulo_venus));
//                txtInfo.setText(getText(R.string.info_venus));
//                break;
//            case 2:
//                img.setImageResource(R.drawable.tierra);
//                txtTitulo.setText(getText(R.string.titulo_tierra));
//                txtInfo.setText(getText(R.string.info_tierra));
//                break;
//            case 3:
//                img.setImageResource(R.drawable.marte);
//                txtTitulo.setText(getText(R.string.titulo_marte));
//                txtInfo.setText(getText(R.string.info_marte));
//                break;
//            case 4:
//                img.setImageResource(R.drawable.jupiter);
//                txtTitulo.setText(getText(R.string.titulo_jupiter));
//                txtInfo.setText(getText(R.string.info_jupiter));
//                break;
//        }

        return v;
    }
}
