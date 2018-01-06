package com.androidapps.guti.teameventsmanager.Model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by ramiro.a.gutierrez on 12/28/2017.
 */

public class Event {
    public String name;

    public String description;

    public Date eventDate;

    public Time eventTime;

    public int ownerId;

    public int teamId;

    public int eventId;
}
