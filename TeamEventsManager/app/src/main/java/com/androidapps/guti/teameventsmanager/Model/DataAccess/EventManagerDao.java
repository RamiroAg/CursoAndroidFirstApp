package com.androidapps.guti.teameventsmanager.Model.DataAccess;


import com.androidapps.guti.teameventsmanager.Model.Event;

import java.util.ArrayList;

/**
 * Created by ramiro.a.gutierrez on 12/29/2017.
 */

public interface EventManagerDao {

    public void insertEvent(Event event);

    public void updateEvent(Event event);

    public void deleteEvent(Event event);

    public ArrayList<Event> getAllEvents();
}
