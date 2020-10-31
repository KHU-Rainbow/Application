package com.example.rainbow;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class date_study extends AppCompatActivity {
    TextView tx1;
    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_study_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // 날짜 값 넘겨 받기
        Intent intent = getIntent();
        tx1 = (TextView)findViewById(R.id.today_date);
        int year = intent.getExtras().getInt("Year");
        int month = intent.getExtras().getInt("Month")+1;
        int day = intent.getExtras().getInt("Day");
        String date = Integer.toString(year)+"년 " + Integer.toString(month)+"월 " + Integer.toString(day) + "일";
        tx1.setText(date);


        TextPaint paint2 = tx1.getPaint();
        float width2 = paint2.measureText(date);

        Shader textShader2 = new LinearGradient(0, 0, width2, tx1.getTextSize(),
                new int[]{
                        Color.parseColor("#fa5050"),
                        Color.parseColor("#faa850"),
                        Color.parseColor("#66ed5f"),
                       Color.parseColor("#60b4f0"),
                        Color.parseColor("#c15df0"),
                }, null, Shader.TileMode.MIRROR);
        tx1.getPaint().setShader(textShader2);
    }

}
