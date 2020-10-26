package com.example.rainbow;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/* textView id : week_1, week_2...  ImageView id : week_pic_1, week_pic_2....
무지개 : rb_pic7
반무지개 : half_rb_pic4
비 : rain_pic5
기본값 : rb_pic8
변수명 week_rbpic1,...
*/
public class weekofRainbow extends AppCompatActivity {
    private ImageView week_rbpic1, week_rbpic2, week_rbpic3, week_rbpic4, week_rbpic5;
    private TextView week1, week2, week3, week4, week5;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekofrainbow_page);

        week_rbpic1 = (ImageView)findViewById(R.id.week_pic_1);
        week_rbpic2 = (ImageView)findViewById(R.id.week_pic_2);
        week_rbpic3 = (ImageView)findViewById(R.id.week_pic_3);
        week_rbpic4 = (ImageView)findViewById(R.id.week_pic_4);
        week_rbpic5 = (ImageView)findViewById(R.id.week_pic_5);

        week_rbpic1.setImageResource(R.drawable.rb_pic7);
        week_rbpic2.setImageResource(R.drawable.half_rb_pic4);
        week_rbpic3.setImageResource(R.drawable.rain_pic5);
        week_rbpic4.setImageResource(R.drawable.rb_pic7);
        week_rbpic5.setImageResource(R.drawable.rb_pic8);

        week1 = (TextView) findViewById(R.id.week_1);
        week2 = (TextView) findViewById(R.id.week_2);
        week3 = (TextView) findViewById(R.id.week_3);
        week4 = (TextView) findViewById(R.id.week_4);
        week5 = (TextView) findViewById(R.id.week_5);
        // 빨 - 주 - 초 - 파 - 보
        week1.setTextColor(Color.parseColor("#eb4934"));
        week2.setTextColor(Color.parseColor("#eba834"));
        week3.setTextColor(Color.parseColor("#3bba14"));
        week4.setTextColor(Color.parseColor("#1288cc"));
        week5.setTextColor(Color.parseColor("#a753f5"));

        // 툴바 지정
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }

}
