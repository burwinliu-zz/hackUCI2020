package com.example.hackuci2020;

import com.example.hackuci2020.APIInterface;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;

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

    public Event getEvent(TimeRepresentation time){
        String[] columns = {
                DBHelper.COLUMN_NAME_MINUTE,
                DBHelper.COLUMN_NAME_HOUR,
                DBHelper.COLUMN_NAME_DAY,
                DBHelper.COLUMN_NAME_MONTH,
                DBHelper.COLUMN_NAME_YEAR
        };
        String selection =
                DBHelper.COLUMN_NAME_MINUTE + " =? AND" +
                DBHelper.COLUMN_NAME_HOUR + " =? AND" +
                DBHelper.COLUMN_NAME_DAY + " =? AND" +
                DBHelper.COLUMN_NAME_MONTH + " =? AND" +
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
            while (cursor.moveToNext()) {
                if (valueExistsStart(cursor.getColumnIndex(DBHelper.COLUMN_NAME_UNIQUE_TIME_ID))) {
                    String[] col = {
                            DBHelper.COLUMN_NAME_UNIQUE_TIME_ID
                    };
                    String sel = DBHelper.COLUMN_NAME_UNIQUE_TIME_ID + " =?";
                    String arg =
                            Integer.toString(cursor.getColumnIndex(DBHelper.COLUMN_NAME_UNIQUE_TIME_ID));
                    cursor1 = database.query(DBHelper.TABLE_TIME, columns, selection,
                            selectionArgs, null, null, null, null);
                    cursor1.moveToFirst();
                    if(cursor1.moveToNext()) {
//                        TimeRepresentation start = getTime(cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_START_ID)));
//                        TimeRepresentation end = getTime(cursor1.getFloat(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_END_ID)));
//

//                        return new Event(
//                                cursor1.getString(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_TITLE)),
//                                cursor1.getInt(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_LOCATION_ID)),
//                                cursor1.getFloat(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_LONGITUDE)),
//                                cursor1.getFloat(cursor1.getColumnIndex(DBHelper.COLUMN_NAME_LATITUDE)),
//                                start,
//                                end,
//                                cursor1.getColumnIndex(DBHelper.COLUMN_NAME_DESCRIPTION),
//                                cursor1.getColumnIndex(DBHelper.COLUMN_NAME_TRAVELTYPE)
//                        );
                    }
                }
            }
        }finally {
            if(cursor != null && !cursor.isClosed())
                cursor.close();
            if(cursor1 != null && !cursor1.isClosed())
                cursor1.close();
        }
        return null;
    }

    public ArrayList<Event> getDaysEvents(TimeRepresentation time){
        return new ArrayList<Event>();
    }

    //todo test, dev seems done
    private Event getLastEvent(TimeRepresentation time){
        Cursor cursor = null;
        try {
            cursor = database.rawQuery(
                    "SELECT " + DBHelper.COLUMN_NAME_HOUR + " , " + DBHelper.COLUMN_NAME_MINUTE +
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
                if (cursor.getColumnIndex(DBHelper.COLUMN_NAME_HOUR) < time.getHour() ||
                        (cursor.getColumnIndex(DBHelper.COLUMN_NAME_HOUR) == time.getHour() &&
                                cursor.getColumnIndex(DBHelper.COLUMN_NAME_MINUTE) < time.getMinute())) {
                    TimeRepresentation temp = new TimeRepresentation(
                            cursor.getColumnIndex(DBHelper.COLUMN_NAME_MINUTE),
                            cursor.getColumnIndex(DBHelper.COLUMN_NAME_HOUR),
                            cursor.getColumnIndex(DBHelper.COLUMN_NAME_DAY),
                            cursor.getColumnIndex(DBHelper.COLUMN_NAME_MONTH),
                            cursor.getColumnIndex(DBHelper.COLUMN_NAME_YEAR)
                    );
                    if (valueExistsStart(cursor.getColumnIndex(DBHelper.COLUMN_NAME_UNIQUE_TIME_ID))){
                        Event e = getEvent(temp);
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
        int notification = apiInterface.getTime(lastEvent.getLongitude(), lastEvent.getLatitude(),
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

        database.insert(DBHelper.TABLE_EVENT, null, contentValue);
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
