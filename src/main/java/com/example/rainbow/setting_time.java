package com.example.rainbow;
import android.app.Activity;


import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class setting_time  extends AppCompatActivity {
    TextView goal_text;
    TimePicker timepicker;
    int hour, minutes;
    Button GetTime;

    Intent intent = getIntent();
    String today = intent.getExtras().getString("today");

    private final String BASE_URL = "https://r89kbtj8x9.execute-api.us-east-1.amazonaws.com/last/";
    private RainbowAPI mMyAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_time_page);

        //데이터베이스 설정
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mMyAPI= retrofit.create(RainbowAPI.class);
        //final int[] settingtime = {0};

        //오늘 날짜로 설정된 목표 공부 시간 불러오기
        int settingtime = mMyAPI.get_study_goal(today);
        /*
        getCall.enqueue(new Callback<PostItem>() {
            @Override
            public void onResponse(Call<PostItem> call, Response<PostItem> response) {
                if (response.isSuccessful()) {
                    Log.i("Test",response.body().toString());
                    settingtime[0] = response.body().get_goal();
                }
            }
            @Override
            public void onFailure(Call<PostItem> call, Throwable t) {
            }
        });
*/


        // 내장디비 연결
        //final DataBaseHelper DBHelper = new DataBaseHelper(this);
        //설정한 목표시간 불러오기(분단위의 값 return)
        //int settingtime = DBHelper.getSettingTime();
        // 불러온 분 단위의 목표시간 시:분으로 만들기
        settingtime /= 60;
        int settinghours, settingminutes;
        settinghours = settingtime /60;
        settingminutes = settingtime %60;

        //목표시간 텍스트 설정
        final TextView goal_time = (TextView)findViewById(R.id.goal_time);
        String goaltxt = settinghours+"시간 "+settingminutes+"분";
        goal_time.setText(goaltxt);

        //텍스트 꾸미기
        TextPaint paint2 = goal_time.getPaint();
        float width2 = paint2.measureText(goaltxt);
        Shader textShader2 = new LinearGradient(0, 0, width2, goal_time.getTextSize(),
                new int[]{
                        Color.parseColor("#fa5050"),
                        Color.parseColor("#faa850"),
                        Color.parseColor("#66ed5f"),
                        Color.parseColor("#60b4f0"),
                        Color.parseColor("#c15df0"),
                }, null, Shader.TileMode.MIRROR);
        goal_time.getPaint().setShader(textShader2);


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

                //PostItem inputitem = new PostItem();
                //inputitem.set_goal(hour*60+minutes);

                JSONObject object = new JSONObject();
                try {
                    object.put("date",today);
                    object.put("settingtime",(hour*60+minutes)*60);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                int postGoal = mMyAPI.post_goal(object);
                /*
                postGoal.enqueue(new Callback<PostItem>() {
                    @Override
                    public void onResponse(Call<PostItem> call, Response<PostItem> response) {
                        Log.v("Test", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<PostItem> call, Throwable t) {

                    }
                });
*/
                //DBHelper.updateSettingTime(hour*60+minutes);

                // 위에 표시될 텍스트 설정한 시간으로 재설정
                String goaltxt2= hour+"시간 "+minutes+"분";
                goal_time.setText(goaltxt2);

                //재설정한 텍스트 꾸미기
                TextPaint paint = goal_text .getPaint();
                float width = paint.measureText(goaltxt2);
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

        // 툴바 세팅
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    private void initMyAPI(String baseUrl){
//        String baseUrl = "https://r89kbtj8x9.execute-api.us-east-1.amazonaws.com/dev/";

    }
}