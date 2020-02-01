package com.example.hackuci2020;

import com.example.hackuci2020.TimeRepresentation;

public class Event {

    private String name, location, description;
    // Location based off of google map widget

    private float longitude, latitude;

    private TimeRepresentation start_time, end_time;

    int alert_before;
    // Alert this many minutes before the event

    public Event(String event_name, String event_location, float longi, float lati, TimeRepresentation time_start,
                 TimeRepresentation time_end, String event_description){
        name = event_name;
        location = event_location;
        longitude = longi;
        latitude = lati;
        description = event_description;
        start_time = time_start;
        end_time = time_end;
    }

    public String getName() {return name;}
    public String getLocation() {return location;}
    public float getLongitude() {return longitude;}
    public float getLatitude() {return latitude;}
    public String getDescription() {return description;}
    public TimeRepresentation getStartTime() {return start_time;}
    public TimeRepresentation getEndTime() {return end_time;}

    public void setName(String nam) {name = nam;}
    public void setLocation(String loc) {location = loc;}
    public void setLongitude(float new_long) {longitude = new_long;}
    public void setLatitude(float new_lat) {latitude = new_lat;}
    public void setDescription(String desc) {description = desc;}

}