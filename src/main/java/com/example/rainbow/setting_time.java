package com.example.rainbow;
import android.app.Activity;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class setting_time  extends AppCompatActivity {

    TimePicker timepicker;
    int hour, minutes;
    Button GetTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_time_page);

        timepicker = (TimePicker)findViewById(R.id.timePicker1);

        GetTime = (Button)findViewById(R.id.button1);

        timepicker.setIs24HourView(true);

        GetTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                hour = timepicker.getCurrentHour();
                minutes = timepicker.getCurrentMinute();

                Toast.makeText(setting_time.this,  hour + "시간 " + minutes+"분" ,Toast.LENGTH_LONG).show();

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}