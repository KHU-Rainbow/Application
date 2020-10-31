package com.example.rainbow;
import android.app.Activity;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
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
        goal_text = (TextView)findViewById(R.id.goal_time);
        GetTime = (Button)findViewById(R.id.button1);

        timepicker.setIs24HourView(true);
        goal_text  = (TextView) findViewById(R.id.goal_time);


        GetTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                hour = timepicker.getCurrentHour();
                minutes = timepicker.getCurrentMinute();

                TextView tx1 = (TextView)findViewById(R.id.goal_time);
                //Toast.makeText(setting_time.this,  hour + "시간 " + minutes+"분" ,Toast.LENGTH_LONG).show();
                String t1= hour+"시간 "+minutes+"분";
                tx1.setText(t1);
                TextPaint paint = goal_text .getPaint();
                float width = paint.measureText(t1);

                Shader textShader = new LinearGradient(0, 0, width, goal_text .getTextSize(),
                        new int[]{
                                Color.parseColor("#fa5050"),
                                Color.parseColor("#faa850"),
                                Color.parseColor("#66ed5f"),
                                Color.parseColor("#60b4f0"),
                                Color.parseColor("#c15df0"),
                        }, null, Shader.TileMode.CLAMP);
                goal_text .getPaint().setShader(textShader);

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