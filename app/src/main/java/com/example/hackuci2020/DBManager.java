package com.example.hackuci2020;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;

import java.util.ArrayList;

public class DBManager {
    private Context context;
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public DBManager(Context c) {
        this.context = c;
    }

    public DBManager open() throws SQLException {
        this.dbHelper = new DBHelper(this.context);
        this.database = this.dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.dbHelper.close();
    }

//    public Event getEvent(SQLiteDatabase db, TimeRepresentation time){
//
//    }
//
//    private int[] getTimeID(SQLiteDatabase db, TimeRepresentation time){
//        String table = DBHelper.TABLE_TIME;
//        String[] columns = {DBHelper.COLUMN_NAME_UNIQUE_TIME_ID};
//        String selection = DBHelper.COLUMN_NAME_MINUTE + " =? AND "
//                + DBHelper.COLUMN_NAME_HOUR + " =? AND "
//                + DBHelper.COLUMN_NAME_DAY + " =? AND "
//                + DBHelper.COLUMN_NAME_MONTH + " =? AND "
//                + DBHelper.COLUMN_NAME_YEAR + " =?";
//        String[] selectionArgs = {
//                Integer.toString(time.getMinute()),
//                Integer.toString(time.getHour()),
//                Integer.toString(time.getDay()),
//                Integer.toString(time.getMonth()),
//                Integer.toString(time.getYear())
//        };
//        Cursor cursor = null;
//        ArrayList<Integer> result = new ArrayList<>();
//
//        try {
//            cursor = db.query(table, columns, selection, selectionArgs, null, null, null);
//            cursor.moveToFirst();
//            while(cursor.moveToNext()) {
//                result.add(cursor.getInt(0));
//            }
//
//        }finally {
//            if (cursor != null && !cursor.isClosed()) {
//                cursor.close();
//            }
//        }
//    }
//
//    public void insertEvent(SQLiteDatabase db, Event event){
//        ContentValues contentValue = new ContentValues();
//        contentValue.put(DBHelper.COLUMN_NAME_TITLE, event.getName());
//        contentValue.put(DBHelper.COLUMN_NAME_DESCRIPTION, event.getDescription());
//        contentValue.put(DBHelper.COLUMN_NAME_TRAVELTYPE, event.getTravel());
//        contentValue.put(DBHelper.COLUMN_NAME_START_ID, insertTime(db, event.getStartTime()));
//        contentValue.put(DBHelper.COLUMN_NAME_END_ID, insertTime(db, event.getEndTime()));
//        contentValue.put(DBHelper.COLUMN_NAME_LOCATION_ID,
//                insertLocation(db, event.getLongitude(), event.getLatitude(), event.getLocation()));
//        contentValue.put(DBHelper.COLUMN_NAME_ALERT_ID,
//    }
//
//    private int insertTime(SQLiteDatabase db, TimeRepresentation time){
//
//    }
//
//    private int insertLocation(SQLiteDatabase db, float longitude, float lat, String address){
//        //returns the unique identifier of the object
//
//    }
//
//    private boolean valueExistsTime(int unique_code){
//
//    }
//
//    private boolean valueExistsLocation(int unique_code){
//
//    }
}
