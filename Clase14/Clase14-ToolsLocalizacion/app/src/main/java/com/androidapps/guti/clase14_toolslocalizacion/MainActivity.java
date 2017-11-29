package com.androidapps.guti.clase14_toolslocalizacion;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener, OnMapReadyCallback {
    private LocationManager locManager;
    public boolean flagActivarGps = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //Método que chequea MIS permisos
        //Paso una constante que referencia al permiso que estoy queriendo dar (ACCESS_FINE_LOCATION y ACCESS_COARSE_LOCATION)
        //Si no los tengo que lanzarle al usuario un dialogo para que acepte los permisos
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && 		         ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            //Este bloque es fijo, sólo cambiarán los tipos de permisos que incluyo en el array
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, //Creo un array de strings con tdos los permisos que necesito que el user acepte
                    0); //request code, puede ser cualquier número
            return; //Siempre tengo que salir si el ususrio no acepta porque no puedo ejecutar los métodos siguientes
        }
        LocationListener miLocListener = new GpsListener();

        //Método que se encarga de la gestión de la ubicación
        locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, miLocListener);

        //Para interactuar con el mapa, no puedo usar un findviewById
        //Tengo que setear un listener que me diga cuando el mapa está listo
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);   //Le paso el id del fragment
        mapFragment.getMapAsync(this);  //devolver el mapa de forma asincrónica
    }

    //se ejecuta cuando el usuario acepta o no los permisos necesitados
    //el request code es el que yo definí más arriba
    //el array de permisos es el mismo que antes y la posición coincide con la del array de grantResults
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(grantResults[0]== PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED)
        {
            try {
                Log.d("a","version nueva, habilito location, se asigno el permiso");
                LocationListener miLocListener = new GpsListener();
                locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, miLocListener);
            }catch(SecurityException e){}
        }
        //Podría agregar un else para decirle al user que si no acepta los permisos, bla bla bla...
    }

//    Para detectar si el gps esta encendido o no
    @Override
    protected void onResume() {
        super.onResume();

        if (locManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ==
                false && flagActivarGps == false) {
            // creamos el dialogo para que el user prenda el GPS
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alerta!");
            builder.setMessage("Se debe encender el GPS");
            builder.setPositiveButton("Aceptar", this);
            builder.setNegativeButton("Cancelar", null);
            AlertDialog ad = builder.create();
            ad.show();
            flagActivarGps=true; //Esto se hace una vez sola
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Intent i = new Intent(android.provider.Settings.
                ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(i);
    }

    //Desde acá SI se puede usar el mapa. Ya está lísto para ser usado
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Se pueden poner los pinchitos (marker) y demás cosas que interactuan con el mapa
        LatLng posObelisco = new LatLng(-34.603559, -58.381478);

        MarkerOptions markerObelisco = new MarkerOptions(); //Es como un descriptor del marker
        markerObelisco.position(posObelisco);
        markerObelisco.title("Obelisco");
        markerObelisco.snippet("67,5m");    //Lo que dice al clickear el en marker
        markerObelisco.icon(BitmapDescriptorFactory.
                fromResource(R.mipmap.ic_launcher));

        googleMap.addMarker(markerObelisco); //Agrego el marker al mapa y lo devuelve

        // Creamos una polylinea
        PolylineOptions pol = new PolylineOptions();
        pol.add(new LatLng(-34.607284, -58.381390));
        pol.add(new LatLng(-34.607398, -58.383483));
        pol.add(new LatLng(-34.609169, -58.383507));
        pol.color(0x80FF0000); // Rojo con transparencia
        pol.width(6); // ancho (0 a 10)
        googleMap.addPolyline(pol);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(posObelisco, 15));

        try {
            googleMap.setMyLocationEnabled(true);
        }
        catch (SecurityException e){

        }
    }
}
