package com.androidapps.guti.teameventsmanager.Model.DataAccess;

import com.androidapps.guti.teameventsmanager.MainActivity;
import com.androidapps.guti.teameventsmanager.Model.Event;
import com.androidapps.guti.teameventsmanager.Services.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramiro.a.gutierrez on 12/29/2017.
 */

public class JsonDao implements EventManagerDao {
    private MainActivity activity;
    public JsonDao(MainActivity activity){
        this.activity = activity;
    }

    @Override
    public void insertEvent(Event event) {

    }

    @Override
    public void updateEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }

    @Override
    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> eventList = new ArrayList<Event>();
        JsonParser parser = new JsonParser();
        eventList = parser.getEventsFromJsonArray(readJsonEventsFile());
        return eventList;
    }

    public String readJsonEventsFile() {
        String json = null;
        try {
            InputStream is = this.activity.getAssets().open("Events.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
