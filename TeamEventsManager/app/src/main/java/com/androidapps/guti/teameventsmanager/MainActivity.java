package com.androidapps.guti.teameventsmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.androidapps.guti.teameventsmanager.events.NewEventFragment;
import com.androidapps.guti.teameventsmanager.home.HomeController;
import com.androidapps.guti.teameventsmanager.home.HomeFragment;
import com.androidapps.guti.teameventsmanager.home.HomeScreenManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private HomeController controller;
    private HomeScreenManager screenManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //El DL es el elemento que contiene todo (vista + menú lateral)
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //Las últimas dos cadenas son textos que se mostraban en la toolbar, ahora no se muestran
        drawer.addDrawerListener(toggle); //Hace que aparezca el boton de tres rayitas que abre el menú lateral
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //---------------------------------------------------------------------------------------------
        //A esta altura el fragment no está cargado, entonces no se pueden capturar los controles
        //Tendría que cargar el screen manager al momento de cargar el fragment

        showFragment(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_item_events) {
            Log.d("NavigationDrawer", "Events Item pressed");
            showFragment(1);
        } else if (id == R.id.nav_item_maintenance) {
            Log.d("NavigationDrawer", "Maintenance Item pressed");
            showFragment(1);
        } else if (id == R.id.nav_item_team1) {
            Log.d("NavigationDrawer", "Team1 Item presed");
        } else if (id == R.id.nav_item_team2) {
            Log.d("NavigationDrawer", "Team2 Item presed");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * El Activity siempre será el encargado de manipular fragments
     * Carga en pantalla determinado Fragment
     * @param contentNumber
     */
    public void showFragment(int contentNumber)
    {
        Fragment fragment;

        switch (contentNumber) {
            case 0:     //Home
                fragment = new HomeFragment();
                break;
            case 1:     //Events
                fragment = new com.androidapps.guti.teameventsmanager.events.HomeFragment();
                break;
            case 2:
                fragment = new NewEventFragment();
                break;
            default:
                fragment = new HomeFragment();
                break;
        }

        //Objeto que permite hacer el intercambio de Fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, fragment) //Remplaza un fragment
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
        //Si hay algún fragment en el layout "contenedor" lo saca y en su lugar pone fragment

    }

}
