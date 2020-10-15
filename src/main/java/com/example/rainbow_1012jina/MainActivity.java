package com.example.rainbow_1012jina;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //이 버튼 누르면 setting time페이지로 이동함
    public void go_to_setting_time(View view){
        Intent intent = new Intent(this, setting_time.class);
        startActivity(intent);
    }

}




