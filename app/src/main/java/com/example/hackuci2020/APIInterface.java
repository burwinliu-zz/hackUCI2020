package com.example.hackuci2020;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIInterface {
    public APIInterface(){}

    public int getTime(double startLong, double startLat, double endLong, int endLat, int transport) {
        String travelMode, wayPoint1, wayPoint2;

        wayPoint1 = startLat + "," + startLong;
        wayPoint2 = endLat + "," + endLong;

        if (transport == 0)
            travelMode = "Driving";
        else
            travelMode = "Walking";


        String url = "http://dev.virtualearth.net/REST/v1/Routes/" + travelMode +
                "?wp.0=" + wayPoint1 + "&wp.1=" + wayPoint2 +
                "&key=" + BuildConfig.bingAPIKey;

        String page = GetJsonData(url);
        try {
            JSONObject jsonObject = new JSONObject(page);
            return (int) jsonObject.get("travelDuration");
        }
        catch(JSONException e){
            return -1;
        }
    }


    public String GetJsonData(String url) {
        try {
            URL Url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) Url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            line = sb.toString();
            connection.disconnect();
            is.close();
            sb.delete(0, sb.length());
            return line;
        } catch (Exception e) {
            return null;
        }
    }
}
