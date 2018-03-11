package com.androidapps.guti.teameventsmanager.Services;

import com.androidapps.guti.teameventsmanager.Model.Event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ramiro.a.gutierrez on 1/20/2018.
 */

public class JsonParser {
    public Event getEventFromJsonObject(JSONObject object){
        try {
//            JSONObject object = new JSONObject(eventJson);
            Event event = new Event();
            event.eventId = object.getInt("eventId");
            event.name = object.getString("name");
            event.description= object.getString("description");
            event.teamId = object.getInt("teamId");
            event.ownerId= object.getInt("ownerId");
            event.eventDate= CommonServices.getDateFromString(object.getString("eventDate"));
            event.eventTime= CommonServices.getTimeFromString(object.getString("eventTime"));
            return event;
        }
        catch (JSONException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Event> getEventsFromJsonArray(String jsonArray){
        ArrayList<Event> eventList = new ArrayList<Event>();
        Event event;
        try {
            JSONArray array = new JSONArray(jsonArray);
            for (int i = 0 ; i < array.length() ; i++){
                event = this.getEventFromJsonObject(array.getJSONObject(i));
                if(event != null){
                    eventList.add(event);
                }
            }
            return eventList;
        }
        catch (JSONException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
