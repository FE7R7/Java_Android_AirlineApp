package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView whiteDateText;
    private Button b_calendarToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = findViewById(R.id.calendarView_Calendar);
        whiteDateText = findViewById(R.id.text_calendar_2);
        b_calendarToMain = findViewById(R.id.b_calendarToMain);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {

            String myDate = dayOfMonth + "/" + (month +1) +  "/" + year; // note the months start at 0

            whiteDateText.setText(myDate);

        });

        b_calendarToMain.setOnClickListener(view -> {

            Intent i = new Intent(Calendar.this, MainActivity_WelCome.class);

            startActivity(i);

        });

    }

}