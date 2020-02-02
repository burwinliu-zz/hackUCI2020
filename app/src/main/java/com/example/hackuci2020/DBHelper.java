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

        // Location table
        public static final String COLUMN_NAME_UNIQUE_LOCATION_ID = "location_id";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_ADDRESS = "address";

        // Time table
        public static final String COLUMN_NAME_UNIQUE_TIME_ID = "time_id";
        public static final String COLUMN_NAME_MINUTE = "minute";
        public static final String COLUMN_NAME_HOUR = "hour";
        public static final String COLUMN_NAME_DAY = "day";
        public static final String COLUMN_NAME_MONTH = "month";
        public static final String COLUMN_NAME_YEAR = "year";


        // Event table
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
        String CREATE_TIME_TABLE = "CREATE TABLE " + TABLE_TIME +
                "(" +
                    COLUMN_NAME_UNIQUE_TIME_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_MINUTE + " INTEGER ," +
                    COLUMN_NAME_HOUR + " INTEGER ," +
                    COLUMN_NAME_DAY + " INTEGER ," +
                    COLUMN_NAME_MONTH + " INTEGER ," +
                    COLUMN_NAME_YEAR + " INTEGER "+
                ");";

        String CREATE_LOCATION_TABLE = "CREATE TABLE " + TABLE_LOCATION +
                "(" +
                    COLUMN_NAME_UNIQUE_LOCATION_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_ADDRESS+ " TEXT," +
                    COLUMN_NAME_LONGITUDE + " DOBULE(10,5)," +
                    COLUMN_NAME_LATITUDE + " DOBULE(10,5)" +
                ");";

        String CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_EVENT +
                "(" +
                    COLUMN_NAME_TITLE + " TEXT," +
                    COLUMN_NAME_TRAVELTYPE+ " INT," +
                    COLUMN_NAME_DESCRIPTION+ " TEXT," +
                    COLUMN_NAME_LOCATION_ID+ " INT," +
                    COLUMN_NAME_ALERT_ID+ " INT," +
                    COLUMN_NAME_END_ID+ " INT," +
                    COLUMN_NAME_START_ID+ " INT," +

                    "FOREIGN KEY ("+ COLUMN_NAME_LOCATION_ID + ") REFERENCES " +
                        TABLE_LOCATION + "(" + COLUMN_NAME_UNIQUE_LOCATION_ID + "), " +
                    "FOREIGN KEY ("+ COLUMN_NAME_ALERT_ID + ") REFERENCES " +
                        TABLE_TIME + "(" + COLUMN_NAME_UNIQUE_TIME_ID + "), " +
                    "FOREIGN KEY ("+ COLUMN_NAME_END_ID + ") REFERENCES " +
                        TABLE_TIME + "(" + COLUMN_NAME_UNIQUE_TIME_ID + "), " +
                    "FOREIGN KEY ("+ COLUMN_NAME_START_ID + ") REFERENCES " +
                        TABLE_TIME + "(" + COLUMN_NAME_UNIQUE_TIME_ID + ")" +
                ");";

        db.execSQL(CREATE_TIME_TABLE);
        db.execSQL(CREATE_LOCATION_TABLE);
        db.execSQL(CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TIME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATION);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
            onCreate(db);
        }
    }

}
