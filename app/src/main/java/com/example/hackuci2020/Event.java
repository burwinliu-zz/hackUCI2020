package com.example.hackuci2020;

public class Event {

    String name;
    String location;
    // Location based off of google map widget

    int start_time;
    // out of 2400. 1200 is 12:00 PM
    int end_time;

    int day;
    int month;
    int year;
    String description;

    int alert_before;
    // Alert this many minutes before the event

    public Event(String event_name, String event_location, int start, int end, int d, int m, int y, String event_description){
        name = event_name;
        location = event_location;
        start_time = start;
        end_time = end;
        day = d;
        month = m;
        year = y;
        description = event_description;
    }
}