package com.androidapps.guti.teameventsmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.androidapps.guti.teameventsmanager.events.HomeFragment;
import com.androidapps.guti.teameventsmanager.events.ViewPagerFragment;

import java.util.ArrayList;

/**
 * Created by ramiro.a.gutierrez on 1/7/2018.
 */

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 4; //Valor fijo de la cantidad de pantallas de contenido que tendrá mi app

    public ScreenSlidePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Segun la posicion, creo el fragment correspondiente y lo devuelvo
        switch(position)
        {
            //En esta versión no reutilizo fragments, siempre creo uno nuevo
            //Podría usarse un singleton
            case 0 : return new ViewPagerFragment("Hoy");
            case 1 : return new ViewPagerFragment("Semana");
            case 2 : return new ViewPagerFragment("Mes");
            case 3 : return new ViewPagerFragment("Todos");
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return NUM_PAGES;
    }

    // Devolvemos el titulo de cada Fragment
    @Override
    public CharSequence getPageTitle(int position)
    {
        switch(position)
        {
            case 0: return "Hoy";
            case 1: return "Semana";
            case 2: return "Mes";
            default: return "Todos";
        }
    }
}
