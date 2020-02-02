package com.example.hackuci2020;

import com.example.hackuci2020.TimeRepresentation;

public class Event {

    private String name, location, description;
    // Location based off of google map widget

    private float longitude, latitude;

    private TimeRepresentation start_time, end_time;

    //travel type -- int. 0 == driving, 1 == walking, 2 == transit
    private int alert_before, travel_type;
    // Alert this many minutes before the event

    public Event(String event_name, Location l, TimeRepresentation time_start,
                 TimeRepresentation time_end, String event_description, int travel){
        name = event_name;
        location = l.getAddr();
        longitude = l.getLong();
        latitude = l.getLat();
        description = event_description;
        start_time = time_start;
        end_time = time_end;
        travel_type = travel;
    }

    public int getTravel(){
        return travel_type;
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
    public void setTravelType(int travelType) {
        travel_type = travelType;
    }

}