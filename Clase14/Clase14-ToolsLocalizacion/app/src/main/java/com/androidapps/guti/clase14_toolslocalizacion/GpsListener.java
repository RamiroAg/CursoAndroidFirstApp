package com.androidapps.guti.clase14_toolslocalizacion;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by android on 28/11/17.
 */

class GpsListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        Log.d("GPS", "Latitud: " + location.getLatitude());
        Log.d("GPS", "Longitud: " + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
