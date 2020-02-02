package com.example.hackuci2020;

import java.sql.Time;

public class FauxDB {
    public FauxDB(){}

    public TimeRepresentation time1(){
        return new TimeRepresentation(5, 5, 2, 3, 2020);
    }

    public TimeRepresentation time2(){
        return new TimeRepresentation(0, 6, 2, 3, 2020);
    }

    public TimeRepresentation time3(){
        return new TimeRepresentation(20, 6, 2, 3, 2020);
    }

    public TimeRepresentation time4(){
        return new TimeRepresentation(35, 8, 2, 3, 2020);
    }

    public TimeRepresentation time5(){
        return new TimeRepresentation(24, 12, 2, 3, 2020);
    }

    public TimeRepresentation time6(){
        return new TimeRepresentation(8, 17, 2, 3, 2020);
    }

    public Location location1(){
        return new Location( (float) 33.621134, (float) -117.927217, "Newport Beach, CA");
    }

    public Location location2(){
        return new Location( (float) 34.015932, (float) -117.979546,
                "15023 Folger St, Hacienda Heights, CA 91745");
    }

    public Location location3(){
        return new Location( (float) 33.691254, (float) -117.888899, "South Coast Plaza, CA");
    }


}