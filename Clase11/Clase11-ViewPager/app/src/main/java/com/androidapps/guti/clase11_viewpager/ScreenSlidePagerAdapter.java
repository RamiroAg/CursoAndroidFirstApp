package com.androidapps.guti.clase11_viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by android on 07/11/17.
 */

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter
{
    private static final int NUM_PAGES = 3; //Valor fijo de la cantidad de pantallas de contenido que tendrá mi app

    public ScreenSlidePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        // Segun la posicion, creo el fragment correspondiente y lo devuelvo
        switch(position)
        {
            //En esta versión no reutilizo fragments, siempre creo uno nuevo
            //Podría usarse un singleton
            case 0 : return new Pantalla1Fragment();
            case 1 : return new Pantalla2Fragment();
            case 2 : return new Pantalla3Fragment();
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
            case 0: return "Jujuy";
            case 1: return "Santa Cruz";
            default: return "Córdoba";
        }
    }
}