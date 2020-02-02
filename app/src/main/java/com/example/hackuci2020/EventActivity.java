package com.example.hackuci2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class EventActivity extends AppCompatActivity implements TimePickerFragment.OnInputListener {
    TextView dateSelected, hourStartSelected, hourEndSelected, title, description;
    Button input, view, setDateTime, back, submit;
    Spinner alert;
    Calendar calendar = Calendar.getInstance();
    ConstraintLayout textViews;

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

        textViews = findViewById(R.id.textViews);
        title = findViewById(R.id.titleInput);
        description = findViewById(R.id.description);

        alert = findViewById(R.id.alert_dropdown);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(EventActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Alerts));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alert.setAdapter(myAdapter);

        submit = findViewById(R.id.save_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeRepresentation start = new TimeRepresentation(minute_start, hour_start, day, month, year);
                TimeRepresentation end = new TimeRepresentation(minute_end, hour_end, day, month, year);
                Event new_event = new Event(title.getText().toString(), new Location(0, 0, "event_location"), start, end, description.getText().toString(), 0);
            }
        });

        setDateTime = findViewById(R.id.date_Delete);
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
