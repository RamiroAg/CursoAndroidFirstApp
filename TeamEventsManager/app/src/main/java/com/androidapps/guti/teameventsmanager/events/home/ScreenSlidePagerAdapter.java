package com.androidapps.guti.teameventsmanager.events.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.androidapps.guti.teameventsmanager.events.home.ViewPagerFragment;

/**
 * Created by ramiro.a.gutierrez on 1/7/2018.
 */

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 4; //Valor fijo de la cantidad de pantallas de contenido que tendrá mi app
    private static final int TODAY_PAGE = 0;
    private static final int WEEK_PAGE = 1;
    private static final int MONTH_PAGE = 2;
    private static final int ALL_PAGE = 3;

    public ScreenSlidePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Segun la posicion, creo el fragment correspondiente y lo devuelvo
        Bundle bundle = getBundle(position);
        Fragment fragment = new ViewPagerFragment();
        fragment.setArguments(bundle);
//        return fragment;
        switch(position)
        {
            //En esta versión no reutilizo fragments, siempre creo uno nuevo
            //Podría usarse un singleton
            case TODAY_PAGE :return new ViewPagerFragment();
            case WEEK_PAGE : return new ViewPagerFragment();
            case MONTH_PAGE : return new ViewPagerFragment();
            case ALL_PAGE : return new ViewPagerFragment();
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

    public Bundle getBundle(int page){
        Bundle pagerBundle = new Bundle();
        switch (page){
            case TODAY_PAGE:
                pagerBundle.putString("PAGE_TITLE", "Hoy");
                break;
            case WEEK_PAGE:
                pagerBundle.putString("PAGE_TITLE", "Semana");
                break;
            case MONTH_PAGE:
                pagerBundle.putString("PAGE_TITLE", "Mes");
                break;
            case ALL_PAGE:
                pagerBundle.putString("PAGE_TITLE", "Todos");
                break;
        }
        return pagerBundle;
    }
}
