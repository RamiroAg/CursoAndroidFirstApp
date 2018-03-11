package com.androidapps.guti.teameventsmanager.Services;

import android.text.format.DateFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by ramiro.a.gutierrez on 1/19/2018.
 */

public class CommonServices {

    public static Date getDateFromString(String stringDate){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = new Date();
        try {
            date = formatter.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }

    public static Date getTimeFromString(String stringTime){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date time = new Date();
        try {
            time = formatter.parse(stringTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
