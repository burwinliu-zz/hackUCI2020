package com.example.hackuci2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hackuci2020.DBManager;

import java.util.Calendar;

public class EventActivity extends AppCompatActivity implements TimePickerFragment.OnInputListener {

    public interface InputListener{
        void saveEvent(Event e);
        Event getEvent(TimeRepresentation t);
    }

    private InputListener inputListener;

    TextView dateSelected, hourStartSelected, hourEndSelected, title, description;
    Button save, back, setDateTime;
    Spinner alert;
    Calendar calendar = Calendar.getInstance();

    int day = 0;
    int month = 0;
    int year = 0;
    int hour_start = calendar.get(Calendar.HOUR_OF_DAY);
    int minute_start = calendar.get(Calendar.MINUTE);
    int hour_end = hour_start+1;
    int minute_end = minute_start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event);

        dateSelected = findViewById(R.id.date_selected);
        hourStartSelected = findViewById(R.id.time_startSelected);
        hourEndSelected = findViewById(R.id.time_endSelected);

        title = findViewById(R.id.titleInput);
        description = findViewById(R.id.description);

        alert = findViewById(R.id.alert_dropdown);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EventActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Alerts));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alert.setAdapter(myAdapter);

        save = findViewById(R.id.save_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SAVE ITEMS HERE TO DATABASE
                TimeRepresentation start = new TimeRepresentation(minute_start, hour_start, day, month, year);
                TimeRepresentation end = new TimeRepresentation(minute_end, hour_end, day, month, year);
                Event new_event = new Event(title.getText().toString(), new Location(0, 0, "event_location"), start, end, description.getText().toString(), 0);
                //DBManager.insertEvent(new_event)
                //takes all info and puts it out into something
                Log.d("TEST", new_event.getLocation());
//                inputListener.saveEvent(new_event);

                DBManager dbmanager = new DBManager(getApplicationContext());
                dbmanager.open();
                dbmanager.insertEvent(new_event);
//                Log.d("DATABASE", dbmanager.getEvent())
                dbmanager.close();

                startActivity(new Intent(EventActivity.this, MainActivity.class));
            }
        });

        back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });

        setDateTime = findViewById(R.id.date_Set);
        setDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment dialog = new TimePickerFragment();
                dialog.show(getSupportFragmentManager(), "TimePickerFragmentManager");
            }
        });
    }

    protected int getDay(){
        return day;
    }

    protected int getMonth(){
        return month;
    }

    protected int getYear(){
        return year;
    }

    protected int getHourStart(){
        return hour_start;
    }

    protected int getHourEnd(){
        return hour_end;
    }

    protected int getMinuteStart(){
        return minute_start;
    }

    protected int getMinuteEnd(){
        return minute_end;
    }

    //Implemented Interface
    @Override
    public void sendTime(int h_start, int h_end, int m_start, int m_end){
        hour_start = h_start;
        minute_start = m_start;
        hour_end = h_end;
        minute_end = m_end;
    }

    @Override
    public void sendInput(String date, String time_start, String time_end) {
        dateSelected.setText(date);
        hourStartSelected.setText(time_start);
        hourEndSelected.setText(time_end);
    }

    @Override
    public void sendDates(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }
}
