package com.example.hackuci2020;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class DBHelper extends SQLiteOpenHelper {

        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "calendar_event.db";

        public static final String TABLE_TIME = "time_table";
        public static final String TABLE_LOCATION = "location_table";
        public static final String TABLE_EVENT = "event_table";
        public static final String COLUMN_NAME_UNIQUE_LOCATION_ID = "counter";

        public static final String COLUMN_NAME_MINUTE = "minute";
        public static final String COLUMN_NAME_HOUR = "hour";
        public static final String COLUMN_NAME_DAY = "day";
        public static final String COLUMN_NAME_MONTH = "month";
        public static final String COLUMN_NAME_YEAR = "year";
        public static final String COLUMN_NAME_UNIQUE_TIME_ID = "counter";

        public static final String COLUMN_NAME_START_ID = "start_time";
        public static final String COLUMN_NAME_END_ID = "end_time";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_TRAVELTYPE = "travel_type";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_LOCATION_ID = "location";
        public static final String COLUMN_NAME_ALERT_ID = "alert_time";




    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

<<<<<<< HEAD
    //public Event getEvent(TimeRepresentation time){
    //}
=======
//    public Event getEvent(TimeRepresentation time){
//    }
>>>>>>> ed6f053c71274675762111fb44d67c1fe207a7f4
}
