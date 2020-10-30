package com.example.rainbow;
import android.app.Activity;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class setting_time  extends AppCompatActivity {
    TextView goal_text;
    TimePicker timepicker;
    int hour, minutes;
    Button GetTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_time_page);

        timepicker = (TimePicker)findViewById(R.id.timePicker1);
        //goal_text = (TextView)findViewById(R.id.goal_time);
        GetTime = (Button)findViewById(R.id.button1);

        timepicker.setIs24HourView(true);
        /*
           <TextView
        android:id="@+id/goal_time"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_above="@id/timePicker1"
        android:background="@drawable/rectangle"/>
         */

        GetTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                hour = timepicker.getCurrentHour();
                minutes = timepicker.getCurrentMinute();

                Toast.makeText(setting_time.this,  hour + "시간 " + minutes+"분" ,Toast.LENGTH_LONG).show();

            }
        });
        //goal_text.setText(setting_time.this, hour+"시간"+minutes+"분");
        //goal_text.setTextSize(30);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}