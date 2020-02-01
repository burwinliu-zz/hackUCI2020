package com.example.hackuci2020;

import android.util.Log;

import com.example.hackuci2020.DBHelper;
import com.example.hackuci2020.Event;


public class DateTimeInterface {
    public interface AlertModifier{
        // function to change the alert time by updating it (call the get alert time from functions
        // below according to the current data in database
        void changeAlert(int min, int hr, int d, int m, int y);
    }

    public DateTimeInterface(){
    }

    public int inputCalendarEvent(Event input) {
        // Input Calendar Event from user
        return 0;
    }

//    public Event getEvent(TimeRepresentation time){
//        return getEvent(time);
//    }

//    public TimeRepresentation getAlertTime(TimeRepresentation time){
//        /*
//            TimeRepresentation time is start time
//        */
//
//    }
//
//    public Event updateAlertTime(TimeRepresentation time){
//        /*
//            TimeRepresentation time is start time
//        */
//
//    }

    public int getTime(double startLong, double startLat, double endLong, int endLat){
        return 0;
    }

}
