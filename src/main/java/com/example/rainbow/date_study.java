package com.example.rainbow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class date_study extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_study_page);

        // 날짜 값 넘겨 받기
        Intent intent = getIntent();
        TextView thedate = (TextView) findViewById(R.id.textView);
        String str_thedate= intent.getStringExtra("Date");
        if (str_thedate != null)
            thedate.setText(str_thedate);
    }

}
