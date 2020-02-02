package com.example.hackuci2020;

public class Location {

    private float longitude, latitude;
    private String address;

    public Location(float longi, float lati, String addr){
        longitude = longi;
        latitude = lati;
        address = addr;
    }

    public void setLong(int longi){
        longitude = longi;
    }
    public void setLat(int lati){
        latitude = lati;
    }
    public void setAddr(String addr){
        address = addr;
    }
    public float getLong(){
        return longitude;
    }
    public float getLat(){
        return latitude;
    }
    public String getAddr(){
        return address;
    }
}
