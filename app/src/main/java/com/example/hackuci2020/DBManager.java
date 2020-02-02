package com.example.hackuci2020;

import com.example.hackuci2020.APIInterface;
import com.example.hackuci2020.Location;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.Time;
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

    private void updateLastTime(TimeRepresentation time, double longitude, double latitude){

    }

    public void updateEvent(TimeRepresentation time, double longitude, double latitude){

    }

    private void updateTime(TimeRepresentation time, double longitude, double latitude){

    }

    private void updateLocation(TimeRepresentation time, double longitude, double latitude){

    }

    public Event getEvent(TimeRepresentation time){
        String[] columns = {
                DBHelper.COLUMN_NAME_MINUTE,
                DBHelper.COLUMN_NAME_HOUR,
                DBHelper.COLUMN_NAME_DAY,
                DBHelper.COLUMN_NAME_MONTH,
                DBHelper.COLUMN_NAME_YEAR,
                DBHelper.COLUMN_NAME_UNIQUE_TIME_ID
        };
        String selection =
                DBHelper.COLUMN_NAME_MINUTE + " =? AND " +
                DBHelper.COLUMN_NAME_HOUR + " =? AND " +
                DBHelper.COLUMN_NAME_DAY + " =? AND " +
                DBHelper.COLUMN_NAME_MONTH + " =? AND " +
                DBHelper.COLUMN_NAME_YEAR + " =?";
        String[] selectionArgs = {
                Integer.toString(time.getMinute()),
                Integer.toString(time.getHour()),
                Integer.toString(time.getDay()),
                Integer.toString(time.getMonth()),
                Integer.toString(time.getYear())
        };
        Cursor cursor1 = null;
        Cursor cursor = null;

        try {
            cursor = database.query(DBHelper.TABLE_TIME, columns, selection,
                    selectionArgs, null, null, null, null);
            cursor.moveToFirst();
            do {
                if (valueExistsStart(cursor.getInt(
                        cursor.getColumnIndex(DBHelper.COLUMN_NAME_UNIQUE_TIME_ID)))) {
                    Log.d("Manager", "Inside");
                    String[] col = {
                            DBHelper.COLUMN_NAME_START_ID,
                            DBHelper.COLUMN_NAME_END_ID,
                            DBHelper.COLUMN_NAME_TITLE,
                            DBHelper.COLUMN_NAME_TRAVELTYPE,
                            DBHelper.COLUMN_NAME_DESCRIPTION,
                            DBHelper.COLUMN_NAME_LOCATION_ID,
                            DBHelper.COLUMN_NAME_ALERT_ID
                    };
                    String sel = DBHelper.COLUMN_NAME_START_ID + " =?";
                    String[] arg = {
                            Integer.toString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_UNIQUE_TIME_ID))
                    };
//                    cursor1 = database.query(DBHelper.TABLE_EVENT, col, sel,
//                            arg, null, null, null, null);
                    cursor1 = database.rawQuery("SELECT * FROM " + DBHelper.TABLE_EVENT, null);
                    cursor1.moveToFirst();
                    Log.d("Manager", "cursor1 past");
                    if(cursor1.moveToNext()) {
                        Log.d("Manager", "moved past");
                        TimeRepresentation start = getTime(cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_START_ID)));
                        TimeRepresentation end = getTime(cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_END_ID)));
                        Location location = getLocation(cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_LOCATION_ID)));
                        Log.d("Manager", "IN past");
                        Log.d("TRUE WORK", Integer.toString(cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_TRAVELTYPE))));
                        Log.d("ARE WE GOING CRAZY", location.getAddr());
                        return new Event(
                                cursor1.getString(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_TITLE)),
                                location,
                                start,
                                end,
                                cursor1.getString(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_DESCRIPTION)),
                                cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_TRAVELTYPE))
                        );
                    }
                }
            }while (cursor.moveToNext());
        }finally {
            if(cursor != null && !cursor.isClosed())
                cursor.close();
            if(cursor1 != null && !cursor1.isClosed())
                cursor1.close();
        }
        return null;
    }

    //todo test
    public Location getLocation(int unique_id){
        String[] columns = {
                DBHelper.COLUMN_NAME_UNIQUE_LOCATION_ID,
                DBHelper.COLUMN_NAME_LONGITUDE,
                DBHelper.COLUMN_NAME_LATITUDE,
                DBHelper.COLUMN_NAME_ADDRESS
        };
        String selection = DBHelper.COLUMN_NAME_UNIQUE_LOCATION_ID + " =?";
        String[] selectionArgs = { Integer.toString(unique_id) };
        String limit = "1";
        Cursor cursor = null;

        try {
            cursor = database.query(DBHelper.TABLE_LOCATION, columns, selection,
                    selectionArgs, null, null, null, limit);
            cursor.moveToFirst();
            for (String s : cursor.getColumnNames())
                Log.d("Cursor12", s);
            if (cursor.moveToNext())
                return new Location(
                        cursor.getFloat(cursor.getColumnIndex(DBHelper.COLUMN_NAME_LONGITUDE)),
                        cursor.getFloat(cursor.getColumnIndex(DBHelper.COLUMN_NAME_LATITUDE)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_ADDRESS))
                );
            return null;
        }
        finally{
            if(cursor != null && !cursor.isClosed())
                cursor.close();
        }
    }

    //todo test
    public TimeRepresentation getTime(int unique_id){
        String[] columns = {
                DBHelper.COLUMN_NAME_UNIQUE_TIME_ID,
                DBHelper.COLUMN_NAME_HOUR,
                DBHelper.COLUMN_NAME_MINUTE,
                DBHelper.COLUMN_NAME_DAY,
                DBHelper.COLUMN_NAME_MONTH,
                DBHelper.COLUMN_NAME_YEAR
        };
        String selection = DBHelper.COLUMN_NAME_UNIQUE_TIME_ID + " =?";
        String[] selectionArgs = { Integer.toString(unique_id) };

        Cursor cursor = null;
        try {
            cursor = database.query(DBHelper.TABLE_TIME, columns, selection,
                    selectionArgs, null, null, null, null);
            for(String s: cursor.getColumnNames())
                Log.d("Cursor", s);
            cursor.moveToFirst();
            Log.d("Cursor1", Integer.toString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_MINUTE)));
            Log.d("Cursor1", Integer.toString(cursor.getInt(2)));
            Log.d("Cursor1", Integer.toString(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_MINUTE))));
            Log.d("Cursor1", Integer.toString(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_HOUR))));
            Log.d("Cursor1", Integer.toString(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_DAY))));
            Log.d("Cursor1", Integer.toString(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_MONTH))));
            Log.d("Cursor1", Integer.toString(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_YEAR))));
            return new TimeRepresentation(
                    cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_MINUTE)),
                    cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_HOUR)),
                    cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_DAY)),
                    cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_MONTH)),
                    cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_YEAR))
            );
        }
        finally{
            if(cursor != null && !cursor.isClosed())
                cursor.close();
        }
    }

    //todo test
    public ArrayList<Event> getDaysEvents(TimeRepresentation time){
        Cursor cursor = null;
        ArrayList<Event> result = new ArrayList<>();
        String table = DBHelper.TABLE_EVENT;
        String[] columns = {
                DBHelper.COLUMN_NAME_YEAR,
                DBHelper.COLUMN_NAME_MONTH,
                DBHelper.COLUMN_NAME_DAY
        };
        String selection =
                DBHelper.COLUMN_NAME_YEAR + " =?" +
                DBHelper.COLUMN_NAME_MONTH + " =?" +
                DBHelper.COLUMN_NAME_DAY + " =?";
        String[] selectionArgs = {
                Integer.toString(time.getYear()),
                Integer.toString(time.getMonth()),
                Integer.toString(time.getDay())
        };
        try{
            cursor = database.query(table, columns, selection, selectionArgs,
                    null, null, null);
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                Location l =
                        getLocation(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_LOCATION_ID)));
                TimeRepresentation start =
                        getTime(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_START_ID)));
                TimeRepresentation end =
                        getTime(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_END_ID)));

                result.add(new Event(
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_TITLE)),
                        l,
                        start,
                        end,
                        cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_DESCRIPTION)),
                        cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_TRAVELTYPE))
                ));
                return result;
            }
        }
        finally{
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return result;
    }

    //todo test, dev seems done
    private Event getLastEvent(TimeRepresentation time){
        Cursor cursor = null;
        try {
            cursor = database.rawQuery(
                    "SELECT " + DBHelper.COLUMN_NAME_HOUR +
                            " , " + DBHelper.COLUMN_NAME_MINUTE +
                            " , " + DBHelper.COLUMN_NAME_DAY +
                            " , " + DBHelper.COLUMN_NAME_MONTH +
                            " , " + DBHelper.COLUMN_NAME_YEAR +
                            " FROM " + DBHelper.TABLE_TIME +
                            " WHERE " + DBHelper.COLUMN_NAME_DAY + " =? AND " +
                            DBHelper.COLUMN_NAME_MONTH + " =? AND " +
                            DBHelper.COLUMN_NAME_YEAR + " =? AND " +
                            DBHelper.COLUMN_NAME_HOUR + " <=?" +
                            " ORDER BY " + DBHelper.COLUMN_NAME_HOUR + " DESC, " +
                            DBHelper.COLUMN_NAME_MINUTE + " DESC",
                    new String[]{
                            Integer.toString(time.getDay()),
                            Integer.toString(time.getDay()),
                            Integer.toString(time.getYear()),
                            Integer.toString(time.getHour())
                    }
            );

            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                if (cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_HOUR)) < time.getHour() ||
                        (cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_HOUR)) == time.getHour() &&
                                cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_MINUTE)) < time.getMinute())) {
                    TimeRepresentation temp = new TimeRepresentation(
                            cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_MINUTE)),
                            cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_HOUR)),
                            cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_DAY)),
                            cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_MONTH)),
                            cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_NAME_YEAR))
                    );
                    if (valueExistsStart(cursor.getColumnIndex(DBHelper.COLUMN_NAME_UNIQUE_TIME_ID))){
                        Event e = getEvent(temp);
                        Log.d("getLASTEVENT", e.getDescription());
                        return e;
                    }
                }
            }
        }
        finally {
            if(cursor!=null && !cursor.isClosed())
                cursor.close();
        }
        return null;
    }

    //todo test, dev seems done
    private ArrayList<Integer> getTimeID(TimeRepresentation time){
        String table = DBHelper.TABLE_TIME;
        String[] columns = {DBHelper.COLUMN_NAME_UNIQUE_TIME_ID};
        String selection = DBHelper.COLUMN_NAME_MINUTE + " =? AND "
                + DBHelper.COLUMN_NAME_HOUR + " =? AND "
                + DBHelper.COLUMN_NAME_DAY + " =? AND "
                + DBHelper.COLUMN_NAME_MONTH + " =? AND "
                + DBHelper.COLUMN_NAME_YEAR + " =?";
        String[] selectionArgs = {
                Integer.toString(time.getMinute()),
                Integer.toString(time.getHour()),
                Integer.toString(time.getDay()),
                Integer.toString(time.getMonth()),
                Integer.toString(time.getYear())
        };
        Cursor cursor = null;
        ArrayList<Integer> result = new ArrayList<>();

        try {
            cursor = database.query(table, columns, selection, selectionArgs,
                    null, null, null);
            cursor.moveToFirst();
            while(cursor.moveToNext()) {
                result.add(cursor.getInt(0));
            }

        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        return result;
    }

    //todo test, development seems done
    public void insertEvent(Event event){
        APIInterface apiInterface = new APIInterface();
        ContentValues contentValue = new ContentValues();
        Event lastEvent = getLastEvent(event.getStartTime());
        int notification = 0;

        if(lastEvent != null)
            notification = apiInterface.getTime(lastEvent.getLongitude(), lastEvent.getLatitude(),
                    event.getLongitude(), event.getLatitude(), event.getTravel());

        updateLastTime(event.getEndTime(), event.getLongitude(), event.getLatitude());


        contentValue.put(DBHelper.COLUMN_NAME_TITLE, event.getName());
        contentValue.put(DBHelper.COLUMN_NAME_DESCRIPTION, event.getDescription());
        contentValue.put(DBHelper.COLUMN_NAME_TRAVELTYPE, event.getTravel());
        contentValue.put(DBHelper.COLUMN_NAME_START_ID, insertTime(database, event.getStartTime()));
        contentValue.put(DBHelper.COLUMN_NAME_END_ID, insertTime(database, event.getEndTime()));
        contentValue.put(DBHelper.COLUMN_NAME_LOCATION_ID,
                insertLocation(database, event.getLongitude(), event.getLatitude(), event.getLocation()));
        contentValue.put(DBHelper.COLUMN_NAME_ALERT_ID, notification);

        database.insert(DBHelper.TABLE_EVENT, "0", contentValue);
    }

    //todo test, dev seems good
    private int insertTime(SQLiteDatabase db, TimeRepresentation time){
        ContentValues contentValue = new ContentValues();

        int i = time.getMinute()+time.getHour()+time.getDay()+time.getMonth()+time.getYear();

        while(valueExistsTime(i))
            ++i;

        contentValue.put(DBHelper.COLUMN_NAME_MINUTE, time.getMinute());
        contentValue.put(DBHelper.COLUMN_NAME_HOUR, time.getHour());
        contentValue.put(DBHelper.COLUMN_NAME_DAY, time.getDay());
        contentValue.put(DBHelper.COLUMN_NAME_MONTH, time.getMonth());
        contentValue.put(DBHelper.COLUMN_NAME_YEAR, time.getYear());
        contentValue.put(DBHelper.COLUMN_NAME_UNIQUE_TIME_ID, i);

        database.insert(DBHelper.TABLE_TIME, null, contentValue);

        return i;
    }

    //todo test, dev seems good
    private int insertLocation(SQLiteDatabase db, float longitude, float latitude, String address){
        //returns the unique identifier of the object
        ContentValues contentValue = new ContentValues();

        int i = (int) longitude + (int) latitude;

        while(valueExistsLocation(i))
            ++i;

        contentValue.put(DBHelper.COLUMN_NAME_LATITUDE, latitude);
        contentValue.put(DBHelper.COLUMN_NAME_LONGITUDE, longitude);
        contentValue.put(DBHelper.COLUMN_NAME_UNIQUE_LOCATION_ID, i);


        return i;
    }

    //todo test, dev seems good
    private boolean valueExistsTime(int unique_code){
        String[] columns = { DBHelper.COLUMN_NAME_UNIQUE_TIME_ID };
        String selection = DBHelper.COLUMN_NAME_UNIQUE_TIME_ID + " =?";
        String[] selectionArgs = { Integer.toString(unique_code) };
        String limit = "1";

        Cursor cursor = database.query(DBHelper.TABLE_TIME, columns, selection,
                selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }

    //todo finished dev, need to test
    private boolean valueExistsLocation(int unique_code){
        String[] columns = { DBHelper.COLUMN_NAME_UNIQUE_LOCATION_ID };
        String selection = DBHelper.COLUMN_NAME_UNIQUE_LOCATION_ID + " =?";
        String[] selectionArgs = { Integer.toString(unique_code) };
        String limit = "1";

        Cursor cursor = database.query(DBHelper.TABLE_LOCATION, columns, selection,
                selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }

    //todo finished dev, need to test
    private boolean valueExistsStart(int unique_code){
        String[] columns = { DBHelper.COLUMN_NAME_START_ID };
        String selection = DBHelper.COLUMN_NAME_START_ID + " =?";
        String[] selectionArgs = { Integer.toString(unique_code) };
        String limit = "1";

        Cursor cursor = database.query(DBHelper.TABLE_EVENT, columns, selection,
                selectionArgs, null, null, null, limit);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }
}
