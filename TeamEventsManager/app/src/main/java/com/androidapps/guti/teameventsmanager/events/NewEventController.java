package com.androidapps.guti.teameventsmanager.events;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.androidapps.guti.teameventsmanager.MainActivity;
import com.androidapps.guti.teameventsmanager.Model.Event;
import com.androidapps.guti.teameventsmanager.R;

import java.util.Calendar;

/**
 * Created by ramiro.a.gutierrez on 1/16/2018.
 */

public class NewEventController implements View.OnClickListener {
    private final MainActivity activity;
    private NewEventScreenManager screenManager;

    private static final String ZERO = "0";
    private static final String SLASH = "/";
    private static final String DOS_PUNTOS = ":";

    //Calendario para obtener fecha & hour
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int month = c.get(Calendar.MONTH);
    final int day = c.get(Calendar.DAY_OF_MONTH);
    final int year = c.get(Calendar.YEAR);

    //Variables para obtener la hour hour
    final int hour = c.get(Calendar.HOUR_OF_DAY);
    final int minute = c.get(Calendar.MINUTE);

    public NewEventController(NewEventScreenManager screenManager, Activity activity){
        this.activity = (MainActivity) activity;
        this.screenManager = screenManager;
        this.screenManager.setButtonListener(this);
    }
    @Override
    public void onClick(View view) {
//        Button btn = (Button) view;
        switch (view.getId()){
            case R.id.btnEventSave:
                saveEventClick();
                break;
            case R.id.ibtnGetTime:
                getTimeClick();
                break;
            case R.id.ibtnGetDate:
                getDateClick();
                break;
        }
    }

    private void getDateClick() {
        DatePickerDialog recogerFecha = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? ZERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? ZERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                screenManager.setEventDate(diaFormateado + SLASH + mesFormateado + SLASH + year);
            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },year, month, day);
        //Muestro el widget
        recogerFecha.show();
    }

    private void getTimeClick(){
        TimePickerDialog recogerHora = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo el hour obtenido: antepone el 0 si son menores de 10
                String horaFormateada =  (hourOfDay < 10)? String.valueOf(ZERO + hourOfDay) : String.valueOf(hourOfDay);
                //Formateo el minute obtenido: antepone el 0 si son menores de 10
                String minutoFormateado = (minute < 10)? String.valueOf(ZERO + minute):String.valueOf(minute);
                //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }
                //Muestro la hour con el formato deseado
                screenManager.setEventTime(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
            //Estos valores deben ir en ese orden
            //Al colocar en false se muestra en formato 12 horas y true en formato 24 horas
            //Pero el sistema devuelve la hour en formato 24 horas
        }, hour, minute, false);

        recogerHora.show();
    }

    private void saveEventClick() {
        Event newEvent = new Event();
        newEvent.name = screenManager.getEventName();
        newEvent.description = screenManager.getEventDescription();
        newEvent.eventDate = screenManager.getEventDate();
        newEvent.eventTime = screenManager.getEventStartTime();
    }
}
