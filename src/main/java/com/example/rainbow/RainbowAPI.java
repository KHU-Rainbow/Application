package com.example.rainbow;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*    데이터베이스를 사용하는 7가지 상황

    1 : GET 메인화면에서 achieve = 0인 String[] datelist 받아 달력에 점 찍을 때
    2 : GET 주간평가화면에서 무지개 색
    3 : GET 일자화면에서 특정 date 주고, int time 받아올 때
    4 : GET 일자화면에서 특정 date 주고, int goal 받아올 때, 시간세팅화면에서 오늘 날짜 주고, int goal 받아올 때
    5 : GET 일자화면에서 특정 date 주고, int detect_time 받아올 때
    6 : POST 시간세팅화면에서 오늘 날짜, int goal 줄 때(return 없음)
*/

public interface RainbowAPI{

    // 1
    @GET("achievement")
    String[] get_achieved_days(@Query("start") String previous, @Query("end") String present);

    // 2
    @GET("estimation")
    int[] get_estimation(@Query("start") String previous, @Query("end") String present);

    // 3
    @GET("time")
    int get_study_time(@Query("target") String date);

    // 4
    @GET("goal")
    int get_study_goal(@Query("target") String date);

    // 5
    @GET("interrupt")
    int get_detected_time(@Query("target") String date);

    // 6
    @POST("goal")
    //int post_goal(@Query("date") String date, @Query("target") int settingtime);
    int post_goal(@Body JSONObject goal);
}