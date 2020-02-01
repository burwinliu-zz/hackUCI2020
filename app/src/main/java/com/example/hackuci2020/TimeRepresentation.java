package com.example.hackuci2020;

public class TimeRepresentation {

    private int min, hr, d, m, y;

    public TimeRepresentation(int mi, int hour, int day, int month, int year){
        min = mi;
        hr = hour;
        d = day;
        m = month;
        y = year;
    }

    public int getMinute(){
        return min;
    }
    public int getHour(){
        return hr;
    }
    public int getDay(){
        return d;
    }
    public int getMonth(){
        return m;
    }
    public int getYear(){
        return y;
    }

    public void setMinute(int m){
        min = m;
    }
    public void setHour(int h){
        hr = h;
    }
    public void setDay(int day){
        d = day;
    }
    public void setMonth(int month){
        m = month;
    }
    public void setYear(int year){
        y = year;
    }

}